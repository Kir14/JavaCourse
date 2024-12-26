package modules.nine.homework.json.parsers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
public class JsoupParser {

    private String pathSource;
    private String pathSave;

    public HashMap<String, Station> linkStation;
    public ArrayList<Station> stations;
    public ArrayList<Station> existStations;
    public HashMap<String, Line> lines;

    public JsoupParser(String pathSource, String pathSave) {
        this.pathSource = pathSource;
        this.pathSave = pathSave;
        linkStation = new HashMap<>();
        lines = new HashMap<>();
        stations = new ArrayList<>();
        existStations = new ArrayList<>();
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
            }
        }
    }

    private Station getStation(Element element, int line) {
        String nameStation = element.select("a").text();
        String link = element.select("a").attr("href");
        Station station = new Station(nameStation, line);
        if(linkStation.containsKey(link)){
            existStations.add(station);
        }
        linkStation.put(link, station);
        return station;
    }

    private Line getLine(Element element) {
        String nameLine = element.select("a").attr("title");
        if (lines.containsKey(nameLine)) {
            return lines.get(nameLine);
        }
        Line line = new Line();
        line.setNameLine(nameLine);
        line.setNumberLine(lines.size() + 1);
        lines.put(nameLine, line);
        return line;
    }

}
