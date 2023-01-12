package org.example.infra.services.jpa;

import org.example.builders.TimetableTemplateModel;

public interface TimetableTemplateService {
    TimetableTemplateModel getTimetableTemplateById(String id);
    TimetableTemplateModel getTimetableTemplateByRouteId(Long routeId);
}
