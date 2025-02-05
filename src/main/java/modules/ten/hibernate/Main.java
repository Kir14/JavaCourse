package modules.ten.hibernate;

import modules.ten.hibernate.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

/*
•	Подключите в ваш проект библиотеку Hibernate.
•	Создайте класс для таблицы Courses.
•	Напишите код, который выводит имя и количество студентов любого курса.
 */

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        List<Course> courses = session.createQuery("FROM Course", Course.class).list();
        courses.forEach(o-> System.out.println(o.getName() + " " + o.getStudentsCount()));

        sessionFactory.close();

    }
}
