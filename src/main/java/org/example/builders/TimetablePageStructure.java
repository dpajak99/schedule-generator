package org.example.builders;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.RouteModel;
import org.example.utils.TimetableTemplateResolver;

import java.io.IOException;
import java.util.*;

@Getter
@Setter
public class TimetablePageStructure {
    static String htmlFooter = "</body></html>";
    List<Template> structure;

    public TimetablePageStructure() {
        this.structure = new ArrayList<>();
    }

    public TimetablePageStructure(List<Template> structure) {
        this.structure = structure;
    }

    public void add(TimetableTemplateModel timetableTemplate, SingleTimetableData stopSingleTimetableData) {
        if (timetableTemplate.isMultipleTemplate()) {
            addOrCreateMultitemplateIfExists(timetableTemplate, stopSingleTimetableData);
        } else {
            structure.add(new SingleTemplate(timetableTemplate, stopSingleTimetableData, stopSingleTimetableData.getRoute()));
        }
    }
    
    public List<RouteModel> getPageRoutes() {
        Set<RouteModel> routes = new HashSet<>();
        for (Template template : structure) {
                routes.addAll(template.getRoutes());
        }
        return new ArrayList<>(routes);
    }

    private void addOrCreateMultitemplateIfExists(TimetableTemplateModel timetableTemplate, SingleTimetableData stopSingleTimetableData) {
        if( structure.isEmpty() ) {
            structure.add(new MultiTemplate(timetableTemplate, List.of(stopSingleTimetableData), List.of(stopSingleTimetableData.getRoute())));
            return;
        }
        for (Template template : structure) {
            if (template instanceof MultiTemplate multiTemplate && multiTemplate.getTimetableTemplate().equals(timetableTemplate)) {
                multiTemplate.add(stopSingleTimetableData, stopSingleTimetableData.getRoute());
                return;
            } else {
                structure.add(new MultiTemplate(timetableTemplate, List.of(stopSingleTimetableData), List.of(stopSingleTimetableData.getRoute())));
            }
        }

    }
    private String getHtmlHeader(String title) throws IOException {
        List<String> timetableIds = new ArrayList<>();
        for(Template template : structure) {
            timetableIds.add(template.getTimetableTemplate().getId());
        }
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("title", title);
        variables.put("timetableTemplates", timetableIds);
        
        return TimetableTemplateResolver.resolveBaseFile("header", variables);
    }

    public String buildHtml() throws IOException {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(getHtmlHeader(""));
        for (TimetablePageStructure.Template template : structure) {
            TimetableTemplateModel timetableTemplate = template.getTimetableTemplate();
            htmlBuilder.append(timetableTemplate.process(template));
        }
        htmlBuilder.append(htmlFooter);

        return htmlBuilder.toString();
    }

    public interface Template {
        TimetableTemplateModel getTimetableTemplate();
        
        List<RouteModel> getRoutes();

        TimetableData getTimeTableData();
    }

    @Getter
    @Setter
    public static class MultiTemplate implements Template {
        List<SingleTimetableData> schedules;
        TimetableTemplateModel timetableTemplate;
        List<RouteModel> routes;
        MultiTimetableData timetableData;
        
        public MultiTemplate(TimetableTemplateModel timetableTemplate, List<RouteModel> routes) {
            this.timetableTemplate = timetableTemplate;
            this.routes = new ArrayList<>(routes);
            this.schedules = new ArrayList<>();
            this.timetableData = new MultiTimetableData();
        }
        
        public MultiTemplate(TimetableTemplateModel timetableTemplate, List<SingleTimetableData> schedules, List<RouteModel> routes) {
            this.timetableTemplate = timetableTemplate;
            this.routes = new ArrayList<>(routes);
            this.schedules = new ArrayList<>(schedules);
            this.timetableData = new MultiTimetableData(schedules);
        }

        void add(SingleTimetableData stopSingleTimetableData, RouteModel routeModel) {
            schedules.add(stopSingleTimetableData);
            timetableData = new MultiTimetableData(schedules);
            routes.add(routeModel);
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
        
        @Override
        public TimetableData getTimeTableData() {
            return timetableData;
        }
    }

    @Getter
    @Setter
    public static class SingleTemplate implements Template {
        SingleTimetableData timetableData;
        TimetableTemplateModel timetableTemplate;
        
        RouteModel route;

        public SingleTemplate(TimetableTemplateModel timetableTemplate, SingleTimetableData timetableData, RouteModel route) {
            this.timetableTemplate = timetableTemplate;
            this.timetableData = timetableData;
            this.route = route;
        }

        @Override
        public List<RouteModel> getRoutes() {
            return List.of(route);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SingleTemplate that)) return false;
            return Objects.equals(timetableData, that.timetableData) && Objects.equals(timetableTemplate, that.timetableTemplate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(timetableData, timetableTemplate);
        }

        @Override
        public TimetableData getTimeTableData() {
            return timetableData;
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
