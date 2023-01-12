package org.example.infra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "route_timetable_templates", schema="schedule")
public class RouteTimetableTemplateEntity {
    @EmbeddedId
    private RouteTimetableTemplateEntityId id;

    @Getter
    @Setter
    @NoArgsConstructor
    @Embeddable
    public static class RouteTimetableTemplateEntityId implements Serializable  {
        @Column(name = "id")
        @OneToOne(cascade = CascadeType.REMOVE)
        @JoinColumn(name = "route_id", referencedColumnName = "id")
        private RouteEntity route;

        @Column(name = "id")
        @OneToOne(cascade = CascadeType.REMOVE)
        @JoinColumn(name = "template_id", referencedColumnName = "id")
        private TimetableTemplateEntity timetableTemplate;
    }
}
