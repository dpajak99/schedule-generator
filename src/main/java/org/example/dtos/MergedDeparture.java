package org.example.dtos;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
@Getter
public class MergedDeparture {
    private DepartureDto departureDto;
    
    private List<String> days;
    
    public MergedDeparture(DepartureDto departureDto, List<String> days) {
        this.days = days;
        this.departureDto = departureDto;
    }
    
    public void addDays(String day) {
        this.days.add(day);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MergedDeparture)) return false;
        MergedDeparture that = (MergedDeparture) o;
        return Objects.equals(departureDto, that.departureDto) && Objects.equals(days, that.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureDto, days);
    }
}