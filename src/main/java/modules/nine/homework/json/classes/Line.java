package modules.nine.homework.json.classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Line {
    private String nameLine;
    private Integer numberLine;
    public List<Station> stations;

    public Line() {
        stations = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Line{" +
                "nameLine='" + nameLine + '\'' +
                ", numberLine=" + numberLine +
                '}';
    }
}
