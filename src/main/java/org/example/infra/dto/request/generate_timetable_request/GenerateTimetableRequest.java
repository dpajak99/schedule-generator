package org.example.infra.dto.request.generate_timetable_request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
public class GenerateTimetableRequest {

    @JsonProperty("max_templates_per_page")
    private int maxTemplatesPerPage;
    @JsonProperty("route_config_list")
    private List<RouteConfigDto> routeConfigDtoList;
}
