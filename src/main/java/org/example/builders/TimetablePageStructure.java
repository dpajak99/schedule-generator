package org.example.builders;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TimetablePageStructure {
    List<Template> structure;

    public TimetablePageStructure() {
        this.structure = new ArrayList<>();
    }

    public TimetablePageStructure(List<Template> structure) {
        this.structure = structure;
    }

    public void add(TimetableTemplate timetableTemplate, StopTimetableData stopTimetableData) {
        if (timetableTemplate.isMultipleTemplate()) {
            addOrCreateMultitemplateIfExists(timetableTemplate, stopTimetableData);
        } else {
            structure.add(new SingleTemplate(timetableTemplate, stopTimetableData));
        }
    }

    private void addOrCreateMultitemplateIfExists(TimetableTemplate timetableTemplate, StopTimetableData stopTimetableData) {
        if( structure.isEmpty() ) {
            structure.add(new MultiTemplate(timetableTemplate, List.of(stopTimetableData)));
            return;
        }
        for (Template template : structure) {
            if (template instanceof MultiTemplate multiTemplate && multiTemplate.getTimetableTemplate().equals(timetableTemplate)) {
                multiTemplate.add(stopTimetableData);
                return;
            } else {
                structure.add(new MultiTemplate(timetableTemplate, List.of(stopTimetableData)));
            }
        }
    }


    public interface Template {
        TimetableTemplate getTimetableTemplate();
    }

    @Getter
    @Setter
    public static class MultiTemplate implements Template {
        List<StopTimetableData> schedules;
        TimetableTemplate timetableTemplate;
        
        public MultiTemplate(TimetableTemplate timetableTemplate) {
            this.timetableTemplate = timetableTemplate;
            this.schedules = new ArrayList<>();
        }
        
        public MultiTemplate(TimetableTemplate timetableTemplate, List<StopTimetableData> schedules) {
            this.timetableTemplate = timetableTemplate;
            this.schedules = new ArrayList<>(schedules);
        }

        void add(StopTimetableData stopTimetableData) {
            schedules.add(stopTimetableData);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MultiTemplate that)) return false;
            return Objects.equals(schedules, that.schedules) && Objects.equals(timetableTemplate, that.timetableTemplate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(schedules, timetableTemplate);
        }

        @Override
        public String toString() {
            return "MultiTemplate{" +
                    "schedules=" + schedules +
                    ", timetableTemplate=" + timetableTemplate +
                    '}';
        }
    }

    @Getter
    @Setter
    public static class SingleTemplate implements Template {
        StopTimetableData schedule;
        TimetableTemplate timetableTemplate;

        public SingleTemplate(TimetableTemplate timetableTemplate, StopTimetableData schedule) {
            this.timetableTemplate = timetableTemplate;
            this.schedule = schedule;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SingleTemplate that)) return false;
            return Objects.equals(schedule, that.schedule) && Objects.equals(timetableTemplate, that.timetableTemplate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(schedule, timetableTemplate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimetablePageStructure)) return false;
        TimetablePageStructure that = (TimetablePageStructure) o;
        return Objects.equals(structure, that.structure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structure);
    }

    @Override
    public String toString() {
        return "TimetablePageStructure{" +
                "structure=" + structure +
                '}';
    }
}
