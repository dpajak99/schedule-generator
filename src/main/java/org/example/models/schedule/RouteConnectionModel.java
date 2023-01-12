package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class RouteConnectionModel {
    private Long id;
    private RouteModel route;
    private StopModel stop;
    private Long isOptional;
    private Long lp;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RouteConnectionModel that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(route, that.route) && Objects.equals(stop, that.stop) && Objects.equals(isOptional, that.isOptional) && Objects.equals(lp, that.lp) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, route, stop, isOptional, lp, description);
    }
}
