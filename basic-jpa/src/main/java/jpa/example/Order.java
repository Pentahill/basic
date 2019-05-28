package jpa.example;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "o")
public class Order {
    Long id;
    int version;
    String itemName;
    int quantity;
    Customer cust;

    @Id
    @GeneratedValue(strategy=AUTO)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Version
    protected int getVersion() { return version; }
    protected void setVersion(int version) {
        this.version = version;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    public Customer getCustomer() { return cust; }
    public void setCustomer(Customer cust) {
        this.cust = cust;
    }
}
