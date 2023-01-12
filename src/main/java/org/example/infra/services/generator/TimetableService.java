package org.example.infra.services.generator;

import org.example.builders.RouteTimetable;
import org.example.builders.StopTimetableConfig;

import java.util.List;

public interface TimetableService {
    List<RouteTimetable> getRouteTimetablesByRoutesId(List<Long> routesId);
    RouteTimetable getRouteTimetableByRouteId(Long routeId);
}
