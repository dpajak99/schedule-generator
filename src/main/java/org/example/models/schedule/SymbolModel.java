package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class SymbolModel {
    private String symbol;
    private String direction;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SymbolModel that)) return false;
        return Objects.equals(symbol, that.symbol) && Objects.equals(direction, that.direction) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, direction, description);
    }
}
