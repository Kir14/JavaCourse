package modules.nine.homework.json.parsers;


import modules.nine.homework.json.classes.Line;
import modules.nine.homework.json.classes.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class JsonParser {

    public ArrayList<Line> lines;
    public ArrayList<ArrayList<Station>> connections;

    public JsonParser(ArrayList<Line> lines, ArrayList<ArrayList<Station>> connections) {
        lines.sort(Comparator.comparing(Line::getNumberLine));
        this.lines = lines;
        this.connections = connections;
    }

    public void writeSubway() {
        JSONObject main = new JSONObject();
        main.put("stations", getStations());
        main.put("lines", getArrayLines());
        main.put("connections", getArrayConnections());

        try {
            FileWriter fw = new FileWriter("src/main/java/modules/nine/homework/json/data/map.json");
            fw.write(main.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private JSONArray getArrayLines() {
        JSONArray linesJson = new JSONArray();
        lines.forEach(line -> {
            JSONObject obj = new JSONObject();
            obj.put("number", line.getNumberLine());
            obj.put("name", line.getNameLine());
            linesJson.add(obj);
        });
        return linesJson;
    }


    private JSONObject getStations() {
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

    private JSONArray getArrayConnections() {
        JSONArray connectionsJson = new JSONArray();
        connections.forEach(node -> {
            JSONArray arr = new JSONArray();
            node.sort(Comparator.comparing(o -> o.getLine().getNumberLine()));
            node.forEach(station -> {
                JSONObject object = new JSONObject();
                object.put("line", station.getLine().getNumberLine().toString());
                object.put("station", station.getNameStation());
                arr.add(object);
            });
            connectionsJson.add(arr);
        });
        return connectionsJson;
    }


}
