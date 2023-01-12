package org.example.infra.services.jpa;

import org.example.models.schedule.RouteModel;

public interface RouteService {
    RouteModel getRouteById(Long id);
}
