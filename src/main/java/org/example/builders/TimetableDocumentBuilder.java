package org.example.builders;

import lombok.Getter;
import org.example.models.*;
import org.example.models.schedule.RouteModel;
import org.example.models.schedule.StopModel;
import org.example.models.schedule.TimetableTemplateModel;

import java.util.*;

public class TimetableDocumentBuilder {
    
    public TimetableBuilderOutput generate(TimetableBuilderInput request) {
        Map<RouteModel, List<TimetablePageStructure>> singleTimetables = new HashMap<>();
        for( RouteTimetable routeTimetable : request.getRouteTimetables() ) {
            List<TimetablePageStructure> routeTimetables = new ArrayList<>();
            for( StopTimetableConfig stopTimetableConfig : routeTimetable.getStopTimetableConfigs() ) {
                routeTimetables.add(getTimetablePageStructure(List.of(stopTimetableConfig)));
            }
            singleTimetables.put(routeTimetable.getRoute(), routeTimetables);
        }
        
        Map<StopModel, List<StopTimetableConfig>> stopTimetables = request.getStopTimetables();
        Map<RoutesWrapper, List<TimetablePageStructure>> sharedTimetables = new HashMap<>();
        for(Map.Entry<StopModel, List<StopTimetableConfig>> stopEntry : stopTimetables.entrySet()) {
            List<StopTimetableConfig> stopTimetableConfigs = stopTimetables.get(stopEntry.getKey());
            TimetablePageStructure timetablePageStructure = getTimetablePageStructure(stopTimetableConfigs);
            RoutesWrapper routes = new RoutesWrapper(new ArrayList<>(timetablePageStructure.getPageRoutes()));

            sharedTimetables.putIfAbsent(routes, new ArrayList<>());
            sharedTimetables.get(routes).add(timetablePageStructure);
        }

        List<TimetableDocumentStructure> singleTimetableDocuments = new ArrayList<>();
        for(Map.Entry<RouteModel, List<TimetablePageStructure>> singleTimetableEntry : singleTimetables.entrySet()) {
            RouteModel routeModel = singleTimetableEntry.getKey();
            String fileName = routeModel.getId().toString();

            TimetableDocumentStructure timetableDocumentStructure = new TimetableDocumentStructure();
            timetableDocumentStructure.setFileName(fileName);
            timetableDocumentStructure.setPages(singleTimetableEntry.getValue());
            singleTimetableDocuments.add(timetableDocumentStructure);
        }
        
        List<TimetableDocumentStructure> sharedTimetableDocuments = new ArrayList<>();
        for(Map.Entry<RoutesWrapper, List<TimetablePageStructure>> sharedTimetableEntry : sharedTimetables.entrySet()) {
            List<RouteModel> routeModels = sharedTimetableEntry.getKey().getRouteModels();
            if(routeModels.size() < 2) continue;
            String fileName = routeModels.stream().map(RouteModel::getId).map(Object::toString).reduce((s, s2) -> s + "_" + s2).orElse("");

            TimetableDocumentStructure timetableDocumentStructure = new TimetableDocumentStructure();
            timetableDocumentStructure.setFileName(fileName);
            timetableDocumentStructure.setPages(sharedTimetableEntry.getValue());
            sharedTimetableDocuments.add(timetableDocumentStructure);
        }
        
        TimetableBuilderOutput timetableBuilderOutput = new TimetableBuilderOutput();
        timetableBuilderOutput.setSingleTimetables(singleTimetableDocuments);
        timetableBuilderOutput.setSharedTimetables(sharedTimetableDocuments);
        return timetableBuilderOutput;
    }

    public TimetablePageStructure getTimetablePageStructure(List<StopTimetableConfig> stopTimetablesData) {
        TimetablePageStructure timetablePageStructure = new TimetablePageStructure();

        for (StopTimetableConfig stopTimetableConfig : stopTimetablesData) {
            TimetableTemplateModel timetableTemplate = stopTimetableConfig.getTimetableTemplate();
            timetablePageStructure.add(timetableTemplate, stopTimetableConfig.getSingleTimetableData());
        }

        return timetablePageStructure;
    }
    
    
    @Getter
    public static class RoutesWrapper {
        List<RouteModel> routeModels;

        public RoutesWrapper(List<RouteModel> routeModels) {
            routeModels.sort(Comparator.comparing(RouteModel::getId));
            this.routeModels = routeModels;
        }
        
        
        public int size() {
            return routeModels.size();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RoutesWrapper that)) return false;

            return Objects.equals(routeModels, that.routeModels);
        }

        @Override
        public int hashCode() {
            return routeModels != null ? routeModels.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "RoutesWrapper{" +
                    "routeModels=" + routeModels +
                    '}';
        }
    }
}

