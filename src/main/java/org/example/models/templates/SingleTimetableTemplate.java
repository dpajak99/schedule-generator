package org.example.models.templates;

import lombok.Getter;
import org.example.dtos.CurrentStopDto;
import org.example.dtos.NextStop;
import org.example.dtos.StopDepartures;
import org.example.dtos.SymbolDescription;

import java.util.Date;
import java.util.List;

@Getter
public class SingleTimetableTemplate implements TimetableTemplate {
    private CurrentStopDto currentStop;
    private Date validityDateStart;
    private Date validityDateEnd;
    private StopDepartures stopDepartures;
    private List<NextStop> nextStops;
    private List<SymbolDescription> symbolDescriptions;
}
