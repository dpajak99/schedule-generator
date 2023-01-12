package org.example.infra.dto.response.generate_timetable_response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.models.TimetableBuilderOutput;

@Getter
@Setter
@NoArgsConstructor
public class GenerateTimetableResponseImpl implements GenerateTimetableResponse {
    private TimetableBuilderOutput timetableBuilderOutput;
}
