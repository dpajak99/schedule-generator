package org.example.infra.services.generator.impl;

import org.example.models.RouteTimetable;
import org.example.models.StopTimetableConfig;
import org.example.models.timetable_data.SingleTimetableData;
import org.example.models.schedule.TimetableTemplateModel;
import org.example.infra.services.generator.TimetableService;
import org.example.infra.services.jpa.RouteConnectionService;
import org.example.infra.services.jpa.RouteService;
import org.example.infra.services.jpa.TimetableTemplateService;
import org.example.models.schedule.RouteConnectionModel;
import org.example.models.schedule.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {
    final TimetableTemplateService timetableTemplateService;
    final RouteService routeService;
    final RouteConnectionService routeConnectionService;

    @Autowired
    public TimetableServiceImpl(TimetableTemplateService timetableTemplateService, RouteService routeService, RouteConnectionService routeConnectionService) {
        this.timetableTemplateService = timetableTemplateService;
        this.routeService = routeService;
        this.routeConnectionService = routeConnectionService;
    }

    @Override
    public List<RouteTimetable> getRouteTimetablesByRoutesId(List<Long> routesId) {
        return routesId.stream().map(this::getRouteTimetableByRouteId).toList();
    }

    @Override
    public RouteTimetable getRouteTimetableByRouteId(Long routeId) {
        RouteModel route = routeService.getRouteById(routeId);
        
        TimetableTemplateModel timetableTemplate = timetableTemplateService.getTimetableTemplateByRouteId(routeId);
        List<RouteConnectionModel> routeConnectionModels = routeConnectionService.getRouteConnectionsByRouteId(routeId);
        List<StopTimetableConfig> stopTimetableConfigList = new ArrayList<>();
        for(RouteConnectionModel routeConnectionModel : routeConnectionModels) {
            SingleTimetableData stopSingleTimetableData = new SingleTimetableData();
            stopSingleTimetableData.setStop(routeConnectionModel.getStop());
            stopSingleTimetableData.setRouteConnection(routeConnectionModel);
            stopSingleTimetableData.setRouteConnections(routeConnectionModels);
            stopSingleTimetableData.setRoute(routeConnectionModel.getRoute());

            StopTimetableConfig stopTimetableConfig = new StopTimetableConfig();
            stopTimetableConfig.setRoute(routeConnectionModel.getRoute());
            stopTimetableConfig.setStop(routeConnectionModel.getStop());
            stopTimetableConfig.setSingleTimetableData(stopSingleTimetableData);
            stopTimetableConfig.setTimetableTemplate(timetableTemplate);

            stopTimetableConfigList.add(stopTimetableConfig);
        }

        RouteTimetable routeTimetable = new RouteTimetable();
        routeTimetable.setRoute(route);
        routeTimetable.setStopTimetableConfigs(stopTimetableConfigList);
        return routeTimetable;
    }
}
