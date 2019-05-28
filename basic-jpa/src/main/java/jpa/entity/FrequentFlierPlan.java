package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "frequent_flier_plan")
public class FrequentFlierPlan {
    @Id
    Integer id;

    @Column(name = "annual_miles")
    Integer annualMiles;
}
