package jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class LineItem {
    @Id
    Integer id;

    boolean shipped;

    BigDecimal price;

    @ManyToOne
    Product product;
}
