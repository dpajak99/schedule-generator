package org.example.infra.services.generator.impl;

import org.example.builders.*;
import org.example.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import org.example.infra.dto.request.generate_timetable_request.RouteConfigDto;
import org.example.infra.dto.response.generate_timetable_response.GenerateTimetableResponse;
import org.example.infra.dto.response.generate_timetable_response.GenerateTimetableResponseImpl;
import org.example.infra.services.generator.TimetableService;
import org.example.infra.services.generator.TimetableGeneratorService;
import org.example.infra.services.jpa.RouteService;
import org.example.models.RouteTimetable;
import org.example.models.TimetableBuilderInput;
import org.example.models.TimetableBuilderOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableGeneratorServiceImpl implements TimetableGeneratorService {
    final RouteService routeService;

    final TimetableService timetableService;

    @Autowired
    public TimetableGeneratorServiceImpl(RouteService routeService, TimetableService timetableService) {
        this.routeService = routeService;
        this.timetableService = timetableService;
    }

    @Override
    public GenerateTimetableResponse generateTimetable(GenerateTimetableRequest generateTimetableRequest) {
        TimetablePdfBuilder timetablePdfBuilder = new TimetablePdfBuilder();
        TimetableDocumentBuilder timetableDocumentBuilder = new TimetableDocumentBuilder();

        List<Long> routesId = generateTimetableRequest.getRouteConfigDtoList().stream().map(RouteConfigDto::getRouteId).toList();
        List<RouteTimetable> routeTimetables = timetableService.getRouteTimetablesByRoutesId(routesId);

        TimetableBuilderInput timetableBuilderInput = new TimetableBuilderInput();
        timetableBuilderInput.setRouteTimetables(routeTimetables);

        TimetableBuilderOutput timetableBuilderOutput = timetableDocumentBuilder.generate(timetableBuilderInput);
        
        try {
            timetablePdfBuilder.saveAll(timetableBuilderOutput.getSingleTimetables(), "single");
            timetablePdfBuilder.saveAll(timetableBuilderOutput.getSharedTimetables(), "shared");
        } catch (Exception e) {
            throw new RuntimeException("Cannot save timetables: " + e);
        }


        GenerateTimetableResponseImpl generateTimetableResponse = new GenerateTimetableResponseImpl();
        return generateTimetableResponse;
    }
}
