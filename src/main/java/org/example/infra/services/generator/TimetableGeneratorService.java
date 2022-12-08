package org.example.infra.services.generator;

import org.example.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import org.example.infra.dto.response.generate_timetable_response.GenerateTimetableResponse;

public interface TimetableGeneratorService {
    GenerateTimetableResponse generateTimetable(GenerateTimetableRequest generateTimetableRequest);
}
