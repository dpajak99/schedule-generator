package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class RouteModel {
    private Long id;
    private LineModel line;
    private String name;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private String comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteModel that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RouteModel{" +
                "id=" + id +
                ", line=" + line.getName() +
                '}';
    }
}
