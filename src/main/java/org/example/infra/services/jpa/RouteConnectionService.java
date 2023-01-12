package org.example.infra.services.jpa;

import org.example.models.schedule.RouteConnectionModel;

import java.util.List;

public interface RouteConnectionService {
    List<RouteConnectionModel> getRouteConnectionsByRouteId(Long routeId);
}
