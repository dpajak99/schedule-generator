package org.example.infra.services.generator;

import org.example.models.RouteTimetable;

import java.util.List;

public interface TimetableService {
    List<RouteTimetable> getRouteTimetablesByRoutesId(List<Long> routesId);
    RouteTimetable getRouteTimetableByRouteId(Long routeId);
}
