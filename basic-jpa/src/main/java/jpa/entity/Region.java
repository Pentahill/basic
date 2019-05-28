package jpa.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Table(name = "region")
@Entity
public class Region {
    @Id
    Integer id;

    @Column(name = "name")
    String name;

    @OneToMany
    @JoinColumn(name = "region_id")
    @MapKey(name = "name")
    Map<String, Cluster> clusterMap;
}
