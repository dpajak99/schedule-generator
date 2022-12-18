package org.example.infra.dto.response.company_timetable_templates;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CompanyTimetableTemplatesResponseImpl implements CompanyTimetableTemplatesResponse {
    @JsonProperty("timetables")
    List<CompanyTimetableTemplateDto> companyTimetableTemplateDtoList;
}
