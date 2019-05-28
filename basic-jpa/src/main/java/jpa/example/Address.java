package jpa.example;

import javax.persistence.*;

@Entity(name = "a")
public class Address {
    Long id;

    int version;

    String street;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getStreet() { return street; }
    public void setStreet(String street) {
        this.street = street;
    }

}
