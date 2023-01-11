package org.example.builders;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TimetableTemplate {
    private String id;
    private boolean multipleTemplate;

    public TimetableTemplate(String id) {
        this.id = id;
    }
    
    public String process(TimetablePageStructure.Template template) {
        return "<template>" + id + "</template>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimetableTemplate that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
