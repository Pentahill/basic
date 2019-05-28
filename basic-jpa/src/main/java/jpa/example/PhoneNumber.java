package jpa.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber {
    @Id
    Long id;

    @ManyToOne
    Employee employee;
}
