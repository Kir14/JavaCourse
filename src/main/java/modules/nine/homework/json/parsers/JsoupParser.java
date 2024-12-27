package modules.nine.homework.json.parsers;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import modules.nine.homework.json.classes.Line;
import modules.nine.homework.json.classes.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RequiredArgsConstructor
public class JsoupParser {

    @ToString
    private class CustomPair {
        public String linkLine;
        public String nameStation;
    }

    private String pathSource;
    private String pathSave;

    //public HashMap<String, Station> linkStation;
    public ArrayList<Station> stations;
    //public ArrayList<Station> existStations;
    public HashMap<String, Line> lines;
    public HashMap<Station, ArrayList<CustomPair>> connectionsAll;
    public ArrayList<ArrayList<Station>> connections;


    public JsoupParser(String pathSource, String pathSave) {
        this.pathSource = pathSource;
        this.pathSave = pathSave;
        //linkStation = new HashMap<>();
        lines = new HashMap<>();
        stations = new ArrayList<>();
        connectionsAll = new HashMap<>();
        connections = new ArrayList<>();
        //existStations = new ArrayList<>();
    }

    public void saveData() {
        Document doc;
        try {
            doc = Jsoup.parse(new File("src/main/java/modules/nine/homework/json/data/site.html"), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element tableBody = doc.select("table[class=\"standard sortable\"]")
                .getFirst()
                .select("tbody")
                .getFirst();
        for (Element row : tableBody.select("tr")) {
            Elements columns = row.select("td");
            if (!columns.isEmpty()) {
                Line line = getLine(columns.get(0));
                Station station = getStation(columns.get(1), line.getNumberLine());
                stations.add(station);
                getConnectionsAll(station, columns.get(3));
            }
        }
        createConnections();
    }

    private void createConnections() {
        HashSet<Station> usedStation = new HashSet<>();
        for (Map.Entry<Station, ArrayList<CustomPair>> conn : connectionsAll.entrySet()) {
            if (usedStation.contains(conn.getKey())) {
                continue;
            }
            ArrayList<Station> stationsConnect = new ArrayList<>();
            stationsConnect.add(conn.getKey());
            usedStation.add(conn.getKey());
            for (CustomPair pair : conn.getValue()) {
                Line line = lines.get(pair.linkLine);
                if (line != null) {
                    Station station = stations.stream()
                            .filter(s -> s.getLineNumber().equals(line.getNumberLine()) && s.getNameStation().equals(pair.nameStation))
                            .findFirst()
                            .orElse(null);
                    if (station != null) {
                        stationsConnect.add(station);
                        usedStation.add(station);
                    } else {
                        System.out.println(conn.getKey() + "    " + pair);
                    }
                }
            }
            if (stationsConnect.size() > 1) {
                connections.add(stationsConnect);
            }
        }
    }

    private void getConnectionsAll(Station station, Element element) {
        Elements conn = element.select("a");
        if (!conn.isEmpty()) {
            ArrayList<CustomPair> listConn = new ArrayList<>();
            for (Element a : conn) {
                String title = a.attr("title");
                int startIndex = title.indexOf("«");
                if (startIndex != -1) {
                    int endIndex = title.indexOf("»", startIndex + 1);
                    CustomPair pair = new CustomPair();
                    pair.nameStation = title.substring(startIndex + 1, endIndex);
                    pair.linkLine = a.select("img")
                            .attr("src");
                    listConn.add(pair);
                }
            }
            connectionsAll.put(station, listConn);
        }
    }

    private Station getStation(Element element, int line) {
        String nameStation = element.select("a").text();
        /*Station station = new Station(nameStation, line);
        if(linkStation.containsKey(link)){
            existStations.add(station);
        }
        linkStation.put(link, station);
        return station;*/
        return new Station(nameStation, line);
    }

    private Line getLine(Element element) {
        String nameLine = element.select("a")
                .attr("title");
        String linkLine = element.select("a")
                .select("img")
                .attr("src");
        if (lines.containsKey(linkLine)) {
            return lines.get(linkLine);
        }
        Line line = new Line();
        line.setNameLine(nameLine);
        line.setNumberLine(lines.size() + 1);
        lines.put(linkLine, line);
        return line;
    }

}
