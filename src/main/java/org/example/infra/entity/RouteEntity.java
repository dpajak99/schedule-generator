package org.example.infra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "routes", schema = "schedule")
public class RouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bus_line_id", referencedColumnName = "id")
    private LineEntity line;

    @Column(name = "details")
    private String description;

    @Column(name = "destination_name")
    private String name;
    
//    @Column(name = "date_start")
//    private Date dateStart;
//
//    @Column(name = "date_end")
//    private Date dateEnd;

    @Column(name = "comments")
    private String comments;
}
