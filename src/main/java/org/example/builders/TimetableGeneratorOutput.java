package org.example.builders;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimetableGeneratorOutput {
    List<TimetableDocumentStructure> singleTimetables;
    List<TimetableDocumentStructure> sharedTimetables;
//        List<TimetableDocumentStructure> singleWithoutSharedTimetables;


}
