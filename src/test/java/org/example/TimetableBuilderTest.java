package org.example;

import junit.framework.TestCase;
import org.example.builders.StopTimetableConfig;
import org.example.builders.TimetableBuilder;
import org.example.builders.TimetablePageStructure;
import org.example.builders.TimetableTemplate;

import java.util.List;

public class TimetableBuilderTest extends TestCase {
    TimetableTemplate km001TimetableTemplate = new TimetableTemplate("km001");
    TimetableTemplate mich001TimetableTemplate = new TimetableTemplate("mich001");
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

        TimetableBuilder timetableBuilder = new TimetableBuilder();

        List<StopTimetableConfig> stopTimetablesData1 = List.of(a1From);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData1);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData()))));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);

        List<StopTimetableConfig> stopTimetablesData2 = List.of(a1From, a2From);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData2);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData(), a2From.getTimetableData()))));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);

        List<StopTimetableConfig> stopTimetablesData3 = List.of(a1From, a2From, t10From);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData3);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData(), a2From.getTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getTimetableData())));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);

        List<StopTimetableConfig> stopTimetablesData4 = List.of(a1From, a1To, a2From, a2To, t10From, t10To);
        actualTimetablePageStructure = timetableBuilder.getTimetablePageStructure(stopTimetablesData4);
        expectedTimetablePageStructure = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData(), a1To.getTimetableData(), a2From.getTimetableData(), a2To.getTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getTimetableData()), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10To.getTimetableData())));
        assertEquals(expectedTimetablePageStructure, actualTimetablePageStructure);
    }

    public void testBuildHtml() {
        String actualHtml;
        String expectedHtml;

        TimetableBuilder timetableBuilder = new TimetableBuilder();
        
        TimetablePageStructure timetablePageStructure1 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData()))));
        TimetablePageStructure timetablePageStructure2 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData(), a2From.getTimetableData()))));
        TimetablePageStructure timetablePageStructure3 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData(), a2From.getTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getTimetableData())));
        TimetablePageStructure timetablePageStructure4 = new TimetablePageStructure(List.of(new TimetablePageStructure.MultiTemplate(km001TimetableTemplate, List.of(a1From.getTimetableData(), a1To.getTimetableData(), a2From.getTimetableData(), a2To.getTimetableData())), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10From.getTimetableData()), new TimetablePageStructure.SingleTemplate(mich001TimetableTemplate, t10To.getTimetableData())));

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
