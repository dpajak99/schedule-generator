package org.example.builders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StopTimetableConfig {
    private String routeId;
    private StopTimetableData timetableData = new StopTimetableData();
    private TimetableTemplate timetableTemplate;
}

