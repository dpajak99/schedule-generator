package org.example.builders;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import org.example.models.TimetableDocumentStructure;
import org.example.models.TimetablePageStructure;

import java.io.*;
import java.util.List;

public class TimetablePdfBuilder {
    final String inputDirectory = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input/";
    final String outputDirectory = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/output/";
    
    public void saveAll(List<TimetableDocumentStructure> documents, String directory) throws IOException {
        for(TimetableDocumentStructure document : documents) {
            save(document, directory);
        }
    }

    public void save(TimetableDocumentStructure timetableDocumentStructure, String directory) throws IOException {
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(inputDirectory);
        PdfWriter pdfWriter = new PdfWriter(outputDirectory + "/"+directory+"/" +timetableDocumentStructure.getFileName() + ".pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        PdfMerger pdfMerger = new PdfMerger(pdfDocument);
        for (TimetablePageStructure timetablePageStructure : timetableDocumentStructure.getPages()) {
            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            PdfDocument pdfPageDocument = new PdfDocument(new PdfWriter(pdfOutputStream));
            String html = timetablePageStructure.buildHtml();
            HtmlConverter.convertToPdf(html, pdfPageDocument, converterProperties);
            pdfPageDocument = new PdfDocument(new PdfReader(new ByteArrayInputStream(pdfOutputStream.toByteArray())));
            pdfMerger.merge(pdfPageDocument, 1, pdfPageDocument.getNumberOfPages());
            pdfPageDocument.close();
        }
        pdfDocument.close();
    }
}
