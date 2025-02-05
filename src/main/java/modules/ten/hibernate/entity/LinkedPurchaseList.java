package modules.ten.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "linked_purchase_list")
@Setter
@Getter
@IdClass(StudentCourseId.class)
public class LinkedPurchaseList {

    @Id
    private Integer studentId;
    @Id
    private Integer courseId;

}
