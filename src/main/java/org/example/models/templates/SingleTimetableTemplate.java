package org.example.models.templates;

import lombok.Getter;
import org.example.models.themyleaf.CurrentStop;
import org.example.models.themyleaf.NextStop;
import org.example.models.themyleaf.StopDepartures;
import org.example.models.themyleaf.SymbolDescription;

import java.util.Date;
import java.util.List;

@Getter
public class SingleTimetableTemplate implements TimetableTemplate {
    private CurrentStop currentStop;
    private Date validityDateStart;
    private Date validityDateEnd;
    private StopDepartures stopDepartures;
    private List<NextStop> nextStops;
    private List<SymbolDescription> symbolDescriptions;
}
