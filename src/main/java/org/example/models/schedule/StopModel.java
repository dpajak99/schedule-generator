package org.example.models.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class StopModel {
    private Long id;
    private String name;
    private String searchName;
    private String destinations;
    private String city;
    private Double lat;
    private Double lng;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StopModel stopModel)) return false;
        return Objects.equals(id, stopModel.id) && Objects.equals(name, stopModel.name) && Objects.equals(searchName, stopModel.searchName) && Objects.equals(destinations, stopModel.destinations) && Objects.equals(city, stopModel.city) && Objects.equals(lat, stopModel.lat) && Objects.equals(lng, stopModel.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, searchName, destinations, city, lat, lng);
    }
}
