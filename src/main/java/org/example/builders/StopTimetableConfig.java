package org.example.builders;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.RouteModel;
import org.example.models.schedule.StopModel;

@Getter
@Setter
public class StopTimetableConfig {
    private RouteModel route;
    private StopModel stop;
    private SingleTimetableData singleTimetableData = new SingleTimetableData();
    private TimetableTemplateModel timetableTemplate;
}

