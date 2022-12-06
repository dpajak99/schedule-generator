package org.example.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "departures", schema="schedule")
public class DepartureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bus_stop_id", referencedColumnName = "id", nullable = false)
    private StopEntity stop;
    
    @OneToOne()
    @JoinColumn(name = "track_id", referencedColumnName = "id")
    private TrackEntity track;
    
    @Column(name = "time_in_min")
    private int timeInMin;
    
    @Column(name = "symbols")
    private String symbols;
    
    @Column(name = "is_last_departure")
    private boolean isLastDeparture;
}
