package jpa.example;

import javax.persistence.*;
import java.util.Collection;
import java.util.Vector;

@Entity(name = "c")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "au")
//    @TableGenerator(name = "au", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    Long id;

    @Version
    int version;

    @ManyToOne
    Address address;

    @Basic
    String description;

    @OneToMany(targetEntity = Order.class, mappedBy = "customer")
    Collection orders = new Vector();
}
