package org.example;

import junit.framework.TestCase;
import org.example.models.StopTimetableConfig;
import org.example.builders.TimetableDocumentBuilder;
import org.example.models.TimetablePageStructure;
import org.example.models.schedule.TimetableTemplateModel;

import java.util.List;

public class TimetableBuilderTest extends TestCase {
    TimetableTemplateModel km001TimetableTemplate = new TimetableTemplateModel("km001");
    TimetableTemplateModel mich001TimetableTemplate = new TimetableTemplateModel("mich001");
    StopTimetableConfig a1From = new StopTimetableConfig();
    StopTimetableConfig a1To = new StopTimetableConfig();
    StopTimetableConfig a2From = new StopTimetableConfig();
    StopTimetableConfig a2To = new StopTimetableConfig();
    StopTimetableConfig t10From = new StopTimetableConfig();
    StopTimetableConfig t10To = new StopTimetableConfig();

    public TimetableBuilderTest() {
        super("Timetable Builder Test");
        km001TimetableTemplate.setMultipleTemplate(true);
        mich001TimetableTemplate.setMultipleTemplate(false);
        a1From.setTimetableTemplate(km001TimetableTemplate);
        a1To.setTimetableTemplate(km001TimetableTemplate);
        a2From.setTimetableTemplate(km001TimetableTemplate);
        a2To.setTimetableTemplate(km001TimetableTemplate);
        t10From.setTimetableTemplate(mich001TimetableTemplate);
        t10To.setTimetableTemplate(mich001TimetableTemplate);
    }

    public void testGetTimetablePageStructure() {
        TimetablePageStructure actualTimetablePageStructure;
        TimetablePageStructure expectedTimetablePageStructure;

        TimetableDocumentBuilder timetableBuilder = new TimetableDocumentBuilder();

        List<StopTimetableConfig> stopTimetablesData1 = List.of(a1From);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData1);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData()))));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);

        List<StopTimetableConfig> stopTimetablesData2 = List.of(a1From, a2From);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData2);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData(), a2From.getSingleTimetableData()))));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);

        List<StopTimetableConfig> stopTimetablesData3 = List.of(a1From, a2From, t10From);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData3);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData(), a2From.getSingleTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getSingleTimetableData())));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);

        List<StopTimetableConfig> stopTimetablesData4 = List.of(a1From, a1To, a2From, a2To, t10From, t10To);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData4);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData(), a1To.getSingleTimetableData(), a2From.getSingleTimetableData(), a2To.getSingleTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getSingleTimetableData()), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10To.getSingleTimetableData())));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);
    }

    public void testBuildHtml() {
        String actualHtml;
        String expectedHtml;

        TimetableDocumentBuilder timetableBuilder = new TimetableDocumentBuilder();
        
        TimetablePageStructure timetablePageStructure1 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData()))));
        TimetablePageStructure timetablePageStructure2 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData(), a2From.getSingleTimetableData()))));
        TimetablePageStructure timetablePageStructure3 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData(), a2From.getSingleTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getSingleTimetableData())));
        TimetablePageStructure timetablePageStructure4 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getSingleTimetableData(), a1To.getSingleTimetableData(), a2From.getSingleTimetableData(), a2To.getSingleTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getSingleTimetableData()), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10To.getSingleTimetableData())));

        actualHtml = timetableBuilder.buildHtml(timetablePageStructure1);
        expectedHtml = "OK";
        assertEquals(expectedHtml, actualHtml);

        actualHtml = timetableBuilder.buildHtml(timetablePageStructure2);
        expectedHtml = "OK";
        assertEquals(expectedHtml, actualHtml);

        actualHtml = timetableBuilder.buildHtml(timetablePageStructure3);
        expectedHtml = "OK";
        assertEquals(expectedHtml, actualHtml);

        actualHtml = timetableBuilder.buildHtml(timetablePageStructure4);
        expectedHtml = "OK";
        assertEquals(expectedHtml, actualHtml);
        
    }
}
