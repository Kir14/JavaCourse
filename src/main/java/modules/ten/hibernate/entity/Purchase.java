package modules.ten.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "purchaselist")
@Setter
@Getter
@IdClass(StudentCourse.class)
public class Purchase {

    @Id
    @Column(name = "student_name")
    private String studentName;
    @Id
    @Column(name = "course_name")
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
