package org.example.models.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "bus_stops", schema="schedule")
public class StopModel {
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
