package jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    Integer id;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;
}
