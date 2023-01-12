package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;
import org.example.models.TimetablePageStructure;
import org.example.infra.entity.TimetableTemplateType;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class TimetableTemplateModel {
    static String baseTemplatePath = "/home/dpajak99/Storage/GitHub/inzynierka/timetablegenerator/timetablegenerator/input/";
    private String id;
    private String uploaderId;
    private TimetableTemplateType type;
    
    public String process(TimetablePageStructure.Template template) throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        StringTemplateResolver templateResolver = new StringTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);

        String content = new String(Files.readAllBytes(Paths.get(baseTemplatePath + id + "/index.html")));
        
        final Context ctx = new Context();
        ctx.setVariables(Map.of("timetable", template.getTimeTableData()));
        return templateEngine.process(content, ctx);
    }
    
    public boolean isMultipleTemplate() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimetableTemplateModel that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
