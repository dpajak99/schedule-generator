package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.models.TimetableDocumentStructure;

import java.util.List;

@Getter
@Setter
public class TimetableBuilderOutput {
    List<TimetableDocumentStructure> singleTimetables;
    List<TimetableDocumentStructure> sharedTimetables;
//        List<TimetableDocumentStructure> singleWithoutSharedTimetables;


}
