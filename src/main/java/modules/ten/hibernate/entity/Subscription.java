package modules.ten.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@IdClass(StudentCourseId.class)
public class Subscription {
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
