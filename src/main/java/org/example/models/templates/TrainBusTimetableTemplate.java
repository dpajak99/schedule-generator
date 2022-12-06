package org.example.models.templates;

import lombok.Getter;

@Getter
public class TrainBusTimetableTemplate implements TimetableTemplate {
    private SingleTimetableTemplate trainSingleTimetableTemplate;
    private SingleTimetableTemplate busSingleTimetableTemplate;
}
