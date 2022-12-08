package org.example.mappers;

import org.example.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import org.example.infra.dto.request.generate_timetable_request.RouteConfigDto;
import org.example.models.TimetableBlueprint;
import org.example.models.TimetablePageBlueprint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TimetableBluePrintMapper {
    
    public TimetableBlueprint mapFromGenerateTimetableRequest(GenerateTimetableRequest generateTimetableRequest) {
        Map<List<Long>, List<TimetablePageBlueprint>> timetableDocuments = new HashMap<>();
        
        
        
        
        return new TimetableBlueprint();
    }
    
    private List<String> extractUniqueTemplateNames(GenerateTimetableRequest generateTimetableRequest) {
        return generateTimetableRequest.getRouteConfigDtoList().stream()
                .map(RouteConfigDto::getTemplate)
                .distinct()
                .collect(Collectors.toList());
    }
}
