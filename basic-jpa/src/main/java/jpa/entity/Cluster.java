package jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "cluster")
public class Cluster {
    @Id
    Integer id;

    @Column(name = "name")
    String name;

}
