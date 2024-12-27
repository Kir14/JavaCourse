package modules.nine.homework.json.classes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private String nameStation;
    //private Integer lineNumber;
    private Line line;

    @Override
    public String toString() {
        return "Station{" +
                "nameStation='" + nameStation + '\'' +
                ", line=" + line.getNumberLine() +
                '}';
    }
}
