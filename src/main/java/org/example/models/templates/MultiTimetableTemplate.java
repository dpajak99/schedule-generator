package org.example.models.templates;

import lombok.Getter;
import lombok.Setter;
import org.example.dtos.CurrentStopDto;
import org.example.dtos.SymbolDescription;

import java.util.Date;
import java.util.List;

@Getter
public class MultiTimetableTemplate implements TimetableTemplate {
    private CurrentStopDto currentStop;
    private List<SingleTimetableTemplate> singleTimetableTemplates;
    private List<SymbolDescription> symbolDescriptions;
    
    boolean hasEqualValidDates() {
        Date validityDateStart = singleTimetableTemplates.get(0).getValidityDateStart();
        Date validityDateEnd = singleTimetableTemplates.get(0).getValidityDateEnd();
        
        for (SingleTimetableTemplate singleTimetableTemplate : singleTimetableTemplates) {
            boolean validityDateStartEquals = singleTimetableTemplate.getValidityDateStart().equals(validityDateStart);
            boolean validityDateEndEquals = singleTimetableTemplate.getValidityDateEnd().equals(validityDateEnd);
            
            if (!validityDateStartEquals || !validityDateEndEquals) {
                return false;
            }
        }
        return true;
    }
}
