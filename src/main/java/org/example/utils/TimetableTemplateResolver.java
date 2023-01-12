package org.example.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class TimetableTemplateResolver {
    static String baseTemplatePath = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input/";
    public static String resolveBaseFile(String fileName, Map<String, Object> variables) throws IOException {
        return resolve("/base/" +fileName+ ".html", variables);
    }

    public static String resolveTemplateFile(String templateId, Map<String, Object> variables) throws IOException {
        return resolve(templateId + "/index.html", variables);
    }

    public static String resolve(String localPath, Map<String, Object> variables) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(baseTemplatePath + localPath)));
        
        TemplateEngine templateEngine = new TemplateEngine();
        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);
        
        Context ctx = new Context();
        ctx.setVariables(variables);
        
        return templateEngine.process(content, ctx);
    }
}
