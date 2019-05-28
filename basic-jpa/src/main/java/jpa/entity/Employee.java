package jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    Integer id;

    String name;

    Integer rating;

    Float salary;

    @OneToOne
    @JoinColumn(name = "depart_id")
    Department department;

    @OneToMany
    @JoinColumn(name = "employee_id")
    Set<FrequentFlierPlan> frequentFlierPlans;
}
