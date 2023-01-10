package org.example.builders;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.RouteModel;
import org.example.models.schedule.StopModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimetableBuilder {
//    private void generate(List<RouteStopsConfig> routeStopsConfigs) {
//        for (RouteStopsConfig routeStopsConfig : routeStopsConfigs) {
//            RouteModel route = routeStopsConfig.getRoute();
//            List<StopModel> stops = routeStopsConfig.getStops();
//        }
//
//    }

    private void generate(RouteStopsConfig routeStopsConfig) {
        List<TimetableStopConfig> timetableStopConfigs = routeStopsConfig.getTimetableStopConfigs();
        Map<StopModel, List<TimetableStopConfig>> timetableConfigByStop = assignTimetableConfigByStop(timetableStopConfigs);
        
        for (StopModel stop : timetableConfigByStop.keySet()) {
            List<TimetableStopConfig> timetableStopConfigList = timetableConfigByStop.get(stop);
        }
    }

    private String buildMultiHtml(List<TimetableStopConfig> timetableStopConfigs) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(getHtmlHeader());
        for (TimetableStopConfig timetableStopConfig : timetableStopConfigs) {
            TimetableTemplate timetableTemplate = timetableStopConfig.getTimetableTemplate();
            timetableTemplate.process(timetableStopConfig.getTimetableData());
        }
        htmlBuilder.append(getHtmlFooter());
        return htmlBuilder.toString();
    }

    private String buildSingleHtml(TimetableStopConfig timetableStopConfig) {
        TimetableTemplate timetableTemplate = timetableStopConfig.getTimetableTemplate();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(getHtmlHeader());
        timetableTemplate.process(timetableStopConfig.getTimetableData());
        htmlBuilder.append(getHtmlFooter());

        return htmlBuilder.toString();
    }

    private String getHtmlHeader() {
        return "<html><head><title>Timetable</title></head><body>";
    }

    private String getHtmlFooter() {
        return "</body></html>";
    }

    private Map<StopModel, List<TimetableStopConfig>> assignTimetableConfigByStop(List<TimetableStopConfig> timetableStopConfigs) {
        Map<StopModel, List<TimetableStopConfig>> stopRouteTimetableConfigMap = new HashMap<>();
        for (TimetableStopConfig timetableStopConfig : timetableStopConfigs) {
            StopModel stop = timetableStopConfig.getStop();
            if (stopRouteTimetableConfigMap.containsKey(stop)) {
                stopRouteTimetableConfigMap.get(stop).add(timetableStopConfig);
            } else {
                stopRouteTimetableConfigMap.put(stop, List.of(timetableStopConfig));
            }
        }
        return stopRouteTimetableConfigMap;
    }

    @Getter
    @Setter
    class RouteStopsConfig {
        RouteModel route;
        List<TimetableStopConfig> timetableStopConfigs;
    }

    @Getter
    @Setter
    class TimetableStopConfig {
        RouteModel route;
        StopModel stop;
        TimetableTemplate timetableTemplate;

        TimetableData timetableData;
    }

    @Getter
    @Setter
    class TimetableData {
        StopDepartures stopDepartures;
    }

    @Getter
    @Setter
    class TimetableTemplate {
        private String name;

        String process(TimetableData timetableData) {
            return "";
        }
    }

    @Getter
    @Setter
    class StopDepartures {

    }
}
