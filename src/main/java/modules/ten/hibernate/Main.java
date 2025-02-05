package modules.ten.hibernate;

import modules.ten.hibernate.entity.Course;
import modules.ten.hibernate.entity.LinkedPurchaseList;
import modules.ten.hibernate.entity.Purchase;
import modules.ten.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

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

        List<Course> coursess = session.createQuery("FROM Course", Course.class).list();
        coursess.forEach(o -> System.out.println(o.getName() + " " + o.getStudentsCount()));
        System.out.println();
        Course c = session.get(Course.class, 1);
        System.out.println(c.getName());
        System.out.println("Teacher: " + c.getTeacher().getName());
        System.out.println("Students:");
        List<Student> studentList = c.getStudents();
        studentList.forEach(o -> System.out.println(o.getName()));

        Transaction transaction = session.beginTransaction();

        String hql = "From " + Purchase.class.getSimpleName();
        List<Purchase> purchases = session.createQuery(hql, Purchase.class).getResultList();
        for (Purchase purchase : purchases) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();

            hql = "FROM " + Student.class.getSimpleName() + " WHERE name = :name";
            Query query = session.createQuery(hql, Student.class);
            query.setParameter("name", purchase.getStudentName());
            Student student = (Student) query.getSingleResult();
            linkedPurchaseList.setStudentId(student.getId());

            hql = "FROM " + Course.class.getSimpleName() + " WHERE name = :name";
            query = session.createQuery(hql, Course.class);
            query.setParameter("name", purchase.getCourseName());
            Course course = (Course) query.getSingleResult();
            linkedPurchaseList.setCourseId(course.getId());
            session.save(linkedPurchaseList);
        }


        transaction.commit();
        sessionFactory.close();


    }
}
