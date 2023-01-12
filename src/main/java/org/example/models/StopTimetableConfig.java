package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.TimetableTemplateModel;
import org.example.models.timetable_data.SingleTimetableData;
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

