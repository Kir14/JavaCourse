package modules.ten.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conn {
    private Connection conn;

    Conn(String url, String user, String pass) throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
    }

    public List<String> getAvgPurMonth() throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(
                "with course_date as(\n" +
                        "select course_name\n" +
                        "\t, extract(YEAR_MONTH from min(p.subscription_date)) min_date \n" +
                        "\t, extract(YEAR_MONTH from max(p.subscription_date)) max_date \n" +
                        "    , count(*) countSells\n" +
                        "from purchaselist p\n" +
                        "group by course_name\n" +
                        ")\n" +
                        "select course_name\n" +
                        "\t,  countSells / (PERIOD_DIFF(max_date, min_date) + 1) avgPurch \n" +
                        "from course_date"
        );
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            String courseName = rs.getString("course_name");
            Double avgPurch = rs.getDouble("avgPurch");
            list.add(courseName + "\t" + avgPurch);
        }
        return list;
    }
}
