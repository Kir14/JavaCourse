package modules.ten.db;

import java.sql.SQLException;
import java.util.List;

/*
Напишите код, который выведет среднее количество покупок в месяц для каждого курса за 2018 год.
Учитывайте диапазон месяцев, в течение которого были продажи. Подробнее в примере
 */

public class AvgPurchMonth {
    public static void main(String[] args) {
        try {
            Conn conn = new Conn("jdbc:mysql://localhost:3306/course", "root", "mysql");
            List<String> list = conn.getAvgPurMonth();
            list.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
