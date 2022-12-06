package org.example.dtos;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class StopDepartures {
    private Map<String, List<DepartureDto>> dayDepartures;

    List<MergedDeparture> getMergedDepartures(String... days) {
        Map<DepartureDto, MergedDeparture> mergedDepartureMap = new HashMap<>();
        for (String day : days) {
            List<DepartureDto> daysToMerge = getDepartures(day);
            for( DepartureDto departureDto : daysToMerge ) {
                if( mergedDepartureMap.containsKey(departureDto) ) {
                    mergedDepartureMap.get(departureDto).addDays(day);
                } else {
                    mergedDepartureMap.put(departureDto, new MergedDeparture(departureDto, List.of(day)));
                }
            }
        }
        return new ArrayList<>(mergedDepartureMap.values());
    }
    
    List<DepartureDto> getDepartures(String day) {
        return dayDepartures.get(day);
    }
    

    
}