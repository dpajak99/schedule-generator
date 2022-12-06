package org.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IElement;

import java.io.*;
import java.util.List;

public class TimetableGenerator {

    void generateTemplate() throws IOException {
        String source1 = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input/test_template/index.html";
        String source2 = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input/test_template/index.html";
        String destination = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/output/output.pdf";

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri("baseUri");
        PdfWriter pdfWriter = new PdfWriter(destination);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        PdfMerger pdfMerger = new PdfMerger(pdfDocument);
        for (String html : List.of(source1, source2)) {
            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            PdfDocument pdfPageDocument = new PdfDocument(new PdfWriter(pdfOutputStream));
            HtmlConverter.convertToPdf(new FileInputStream(html), pdfPageDocument, converterProperties);
            pdfPageDocument = new PdfDocument(new PdfReader(new ByteArrayInputStream(pdfOutputStream.toByteArray())));
            pdfMerger.merge(pdfPageDocument, 1, pdfPageDocument.getNumberOfPages());
            pdfPageDocument.close();
        }
        pdfDocument.close();
    }
}
