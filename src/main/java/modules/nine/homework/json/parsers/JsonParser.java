package modules.nine.homework.json.parsers;


import modules.nine.homework.json.classes.Line;
import modules.nine.homework.json.classes.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class JsonParser {

    private String path;
    public ArrayList<Line> lines;
    public ArrayList<ArrayList<Station>> connections;

    public JsonParser(String path) throws IOException, ParseException {
        this.path = path;
        readFile();
    }

    public static void writeSubway(ArrayList<Line> lines, ArrayList<ArrayList<Station>> connections) {
        try {
            FileWriter fw = new FileWriter("src/main/java/modules/nine/homework/json/data/map.json");

            lines.sort(Comparator.comparing(Line::getNumberLine));
            JSONObject main = new JSONObject();
            main.put("stations", getStations(lines));
            main.put("lines", getArrayLines(lines));
            main.put("connections", getArrayConnections(connections));

            fw.write(main.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static JSONArray getArrayLines(ArrayList<Line> lines) {
        JSONArray linesJson = new JSONArray();
        lines.forEach(line -> {
            JSONObject obj = new JSONObject();
            obj.put("number", line.getNumberLine());
            obj.put("name", line.getNameLine());
            linesJson.add(obj);
        });
        return linesJson;
    }


    private static JSONObject getStations(ArrayList<Line> lines) {
        JSONObject main = new JSONObject();
        lines.forEach(line -> {
            JSONArray stations = new JSONArray();
            for (Station station : line.stations) {
                stations.add(station.getNameStation());
            }
            main.put(line.getNumberLine().toString(), stations);
        });
        return main;
    }

    private static JSONArray getArrayConnections(ArrayList<ArrayList<Station>> connections) {
        JSONArray connectionsJson = new JSONArray();
        connections.forEach(node -> {
            JSONArray arr = new JSONArray();
            node.sort(Comparator.comparing(o -> o.getLine().getNumberLine()));
            node.forEach(station -> {
                JSONObject object = new JSONObject();
                object.put("line", station.getLine().getNumberLine());
                object.put("station", station.getNameStation());
                arr.add(object);
            });
            connectionsJson.add(arr);
        });
        return connectionsJson;
    }

    public void readFile() throws IOException, ParseException {
        JSONObject object = (JSONObject) new JSONParser().parse(new FileReader(path));
        lines = parseLines((JSONArray) object.get("lines"));
        parseStation(lines, (JSONObject) object.get("stations"));
        connections = parseConnections(lines, (JSONArray) object.get("connections"));
        System.out.println();
    }

    private ArrayList<ArrayList<Station>> parseConnections(ArrayList<Line> lines, JSONArray connectionsJSON) {
        ArrayList<ArrayList<Station>> arrConnections = new ArrayList<>();
        connectionsJSON.forEach(arr -> {
            JSONArray node = (JSONArray) arr;
            ArrayList<Station> nodeStations = new ArrayList<>();
            node.forEach(obj -> {
                JSONObject station = (JSONObject) obj;
                int lineNumber = ((Long) station.get("line")).intValue();
                String nameStation = (String) station.get("station");
                Line line = lines.stream()
                        .filter(l -> l.getNumberLine().equals(lineNumber))
                        .findFirst()
                        .orElse(null);
                if (line != null) {
                    Station curStation = line.stations.stream()
                            .filter(s -> s.getNameStation().equals(nameStation))
                            .findFirst()
                            .orElse(null);
                    if (curStation != null) {
                        nodeStations.add(curStation);
                    } else {
                        System.out.println("Не найдена станция " + nameStation);
                    }
                } else {
                    System.out.println("Не найдена линия с номером " + lineNumber);
                }
            });
            arrConnections.add(nodeStations);
        });

        return arrConnections;
    }

    private void parseStation(ArrayList<Line> lines, JSONObject stationsJSON) {
        lines.forEach(line -> {
            JSONArray arrStation = (JSONArray) stationsJSON.get(line.getNumberLine().toString());
            arrStation.forEach(stationName -> {
                Station station = new Station((String) stationName, line);
                line.stations.add(station);
            });
        });
    }

    private ArrayList<Line> parseLines(JSONArray linesJson) {
        ArrayList<Line> arrLines = new ArrayList<>();
        linesJson.forEach(obj -> {
            JSONObject jo = (JSONObject) obj;
            Line line = new Line();
            line.setNameLine((String) jo.get("name"));
            line.setNumberLine(((Long) jo.get("number")).intValue());
            arrLines.add(line);
        });
        return arrLines;
    }
}
