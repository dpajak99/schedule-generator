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
@Table(name = "company_schedule_templates", schema = "schedule")
public class CompanyTimetableTemplate implements Serializable {
  @EmbeddedId
  private CompanyScheduleTemplateId id;

  @Embeddable
  @Getter
  @Setter
  @NoArgsConstructor
  public static class CompanyScheduleTemplateId implements Serializable {
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    private TimetableTemplateEntity template;
  }
}