package jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ship_order")
public class Order {
    @Id
    Integer id;

    Integer quantity;

    @OneToMany
    @JoinColumn(name = "order_id")
    Set<LineItem> lineItems;

    @OneToOne
    Customer customer;
}
