package jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "customer")
@Entity
public class Customer {
    @Id
    Integer id;

    String name;

    Integer status;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "balance_owed")
    Double balanceOwed;

    @OneToMany
    @JoinColumn(name = "customer_id")
    Set<Order> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
