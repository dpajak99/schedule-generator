package org.example.controllers;

import org.example.infra.dto.request.generate_timetable_request.GenerateTimetableRequest;
import org.example.infra.dto.response.generate_timetable_response.GenerateTimetableResponse;
import org.example.infra.dto.response.generate_timetable_response.GenerateTimetableResponseError;
import org.example.infra.services.generator.TimetableGeneratorService;
import org.example.infra.services.generator.impl.TimetableGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/pdf/generate")
public class PdfGeneratorController {
    private final TimetableGeneratorService timetableGeneratorService;
    
    @Autowired
    public PdfGeneratorController(TimetableGeneratorServiceImpl timetableGeneratorService) {
        this.timetableGeneratorService = timetableGeneratorService;
    }

    @PostMapping({"/timetable"})
    public ResponseEntity<GenerateTimetableResponse> generateTimetable(@RequestBody GenerateTimetableRequest generateTimetableRequest) {
        try {
            GenerateTimetableResponse generateTimetableResponse = timetableGeneratorService.generateTimetable(generateTimetableRequest);
            return new ResponseEntity<>(generateTimetableResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new GenerateTimetableResponseError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
