package jpa.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "video_store")
public class VideoStore {
    @Id
    Integer id;

    @OneToOne
    @JoinColumn(name = "location_id")
    Location location;

//    @OneToMany
//    @JoinColumn(name = "video_store_id")
//    @MapKeyClass(Movie.class)
//    Map<Movie, Integer> videoInventory;
}
