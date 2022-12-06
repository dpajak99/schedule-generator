package org.example.models.themyleaf;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class StopDepartures {
    private Map<String, List<Departure>> dayDepartures;

    List<MergedDeparture> getMergedDepartures(String... days) {
        Map<Departure, MergedDeparture> mergedDepartureMap = new HashMap<>();
        for (String day : days) {
            List<Departure> daysToMerge = getDepartures(day);
            for( Departure departureDto : daysToMerge ) {
                if( mergedDepartureMap.containsKey(departureDto) ) {
                    mergedDepartureMap.get(departureDto).addDays(day);
                } else {
                    mergedDepartureMap.put(departureDto, new MergedDeparture(departureDto, List.of(day)));
                }
            }
        }
        return new ArrayList<>(mergedDepartureMap.values());
    }
    
    List<Departure> getDepartures(String day) {
        return dayDepartures.get(day);
    }
    

    
}