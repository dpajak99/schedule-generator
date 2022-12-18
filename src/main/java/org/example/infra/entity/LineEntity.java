package org.example.infra.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "bus_lines", schema="schedule")
public class LineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "version_id", referencedColumnName = "id")
    private TimetableVersionEntity timetableVersion;

    @Column(name = "name")
    private String name;
    
    @Column(name = "comments")
    private String comments;
}
