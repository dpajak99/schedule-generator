package org.example.builders;

import java.util.List;

public class TimetableBuilder {
    static String htmlFooter = "</body></html>";

    public String getHtmlPage(List<StopTimetableConfig> stopTimetablesData) {
        TimetablePageStructure timetablePageStructure = getTimetablePageStructure(stopTimetablesData);
        String html = buildHtml(timetablePageStructure);
        return html;
    }

    public TimetablePageStructure getTimetablePageStructure(List<StopTimetableConfig> stopTimetablesData) {
        TimetablePageStructure timetablePageStructure = new TimetablePageStructure();

        for (StopTimetableConfig stopTimetableConfig : stopTimetablesData) {
            TimetableTemplate timetableTemplate = stopTimetableConfig.getTimetableTemplate();
            timetablePageStructure.add(timetableTemplate, stopTimetableConfig.getTimetableData());
        }

        return timetablePageStructure;
    }

    public String buildHtml(TimetablePageStructure timetablePageStructure) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append(getHtmlHeader(""));
        for (TimetablePageStructure.Template template : timetablePageStructure.getStructure()) {
            TimetableTemplate timetableTemplate = template.getTimetableTemplate();
            htmlBuilder.append(timetableTemplate.process(template));
        }
        htmlBuilder.append(htmlFooter);

        return htmlBuilder.toString();
    }

    private String getHtmlHeader(String title) {
        return "<html><head><title>" + title + "</title></head><body>";
    }
}

