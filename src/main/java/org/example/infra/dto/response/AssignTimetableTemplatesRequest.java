package org.example.infra.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AssignTimetableTemplatesRequest {
    @JsonProperty("company_id")
    private String companyId;
    @JsonProperty("timetable_template_ids")
    private List<String> timetableTemplatesIds;
}
