package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.RouteModel;

import java.util.List;

@Getter
@Setter
public class RouteTimetable {
    private RouteModel route;
    private List<StopTimetableConfig> stopTimetableConfigs;
}
