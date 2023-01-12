package org.example.infra.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bus_stops", schema="schedule")
public class StopEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "search_name")
    private String searchName;

    @Column(name = "destinations")
    private String destinations;

    @Column(name = "city")
    private String city;

    @Column(name = "lat")
    private Double lat;
    
    @Column(name = "lng")
    private Double lng;
}
