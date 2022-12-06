package org.example.models.themyleaf;

import lombok.Getter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
@Getter
public class Departure implements Comparable<Departure> {
    private int timeInMinutes;
    private List<String> symbols;
    
    public String getTimeString(String timeFormat) {
        int hour = timeInMinutes / 60;
        int minute = timeInMinutes % 60;
        LocalTime localTime = LocalTime.of(hour, minute);
        return localTime.format(DateTimeFormatter.ofPattern(timeFormat));
    }

    @Override
    public int compareTo(Departure other) {
        int timeCompare = Integer.compare(timeInMinutes, other.timeInMinutes);
        int symbolsCompare = symbols.toString().compareTo(other.symbols.toString());
        return timeCompare != 0 ? timeCompare : symbolsCompare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departure)) return false;
        Departure that = (Departure) o;
        return timeInMinutes == that.timeInMinutes && Objects.equals(symbols, that.symbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeInMinutes, symbols);
    }

    @Override
    public String toString() {
        return "DepartureDto{" +
                "timeInMinutes=" + timeInMinutes +
                ", symbols=" + symbols +
                '}';
    }
}