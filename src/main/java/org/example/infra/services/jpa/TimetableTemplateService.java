package org.example.infra.services.jpa;

import org.example.models.schedule.TimetableTemplateModel;

public interface TimetableTemplateService {
    TimetableTemplateModel getTimetableTemplateById(String id);
    TimetableTemplateModel getTimetableTemplateByRouteId(Long routeId);
}
