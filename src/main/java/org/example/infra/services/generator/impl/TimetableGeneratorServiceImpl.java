package org.example.infra.services.generator.impl;

import org.example.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import org.example.infra.dto.response.generate_timetable_response.GenerateTimetableResponse;
import org.example.infra.services.generator.TimetableGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class TimetableGeneratorServiceImpl implements TimetableGeneratorService {
    @Override
    public GenerateTimetableResponse generateTimetable(GenerateTimetableRequest generateTimetableRequest) {
        return null;
    }
}
