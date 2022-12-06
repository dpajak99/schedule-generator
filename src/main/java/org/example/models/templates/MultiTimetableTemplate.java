package org.example.models.templates;

import lombok.Getter;
import org.example.models.themyleaf.CurrentStop;
import org.example.models.themyleaf.SymbolDescription;

import java.util.Date;
import java.util.List;

@Getter
public class MultiTimetableTemplate implements TimetableTemplate {
    private CurrentStop currentStop;
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
