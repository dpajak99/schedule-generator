package org.example.infra.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "schedule_templates", schema="schedule")
public class TimetableTemplateEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "uploader_id")
    private String uploaderId;
    @Column(name = "type")
    private String type;
}
