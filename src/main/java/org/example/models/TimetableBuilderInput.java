package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.models.RouteTimetable;
import org.example.models.StopTimetableConfig;
import org.example.models.schedule.StopModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TimetableBuilderInput {
    List<RouteTimetable> routeTimetables;


    public Map<StopModel, List<StopTimetableConfig>> getStopTimetables() {
        Map<StopModel, List<StopTimetableConfig>> stopTimetablesData = new HashMap<>();
        for (RouteTimetable routeTimetable : routeTimetables) {
            for (StopTimetableConfig stopTimetableConfig : routeTimetable.getStopTimetableConfigs()) {
                StopModel stop = stopTimetableConfig.getStop();
                stopTimetablesData.putIfAbsent(stop, new ArrayList<>());
                stopTimetablesData.get(stop).add(stopTimetableConfig);
            }
        }
        return stopTimetablesData;
    }

}
