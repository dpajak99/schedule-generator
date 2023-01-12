package org.example.infra.entity;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "schedule_versions", schema="schedule")
public class TimetableVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;

//    @Column(name = "date_start")
//    private Date dateStart;
//
//    @Column(name = "date")
//    private Date dateEnd;
}
