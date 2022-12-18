package org.example.controllers;

import org.example.infra.dto.response.AssignTimetableTemplatesRequest;
import org.example.infra.dto.response.company_timetable_templates.CompanyTimetableTemplatesResponse;
import org.example.infra.dto.response.company_timetable_templates.CompanyTimetableTemplatesResponseError;
import org.example.infra.dto.response.company_timetable_templates.CompanyTimetableTemplatesResponseImpl;
import org.example.infra.dto.response.update_action_response.UpdateActionResponse;
import org.example.infra.dto.response.update_action_response.UpdateActionResponseError;
import org.example.infra.dto.response.update_action_response.UpdateActionResponseImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/timetable/templates")
public class TimetableTemplatesController {
    @GetMapping({"/company/{companyId}"})
    public ResponseEntity<CompanyTimetableTemplatesResponse> getAvailableCompanyTimetableTemplates(@PathVariable Long companyId) {
        try {
            System.out.println("Get timetable templates for company with id: " + companyId);
            CompanyTimetableTemplatesResponse companyTimetableTemplatesResponse = new CompanyTimetableTemplatesResponseImpl();
            return new ResponseEntity<>(companyTimetableTemplatesResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new CompanyTimetableTemplatesResponseError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping({"/upload"})
    public ResponseEntity<UpdateActionResponse> uploadTimetableTemplate(@RequestBody MultipartFile templateFile) {
        try {
            System.out.println("Upload timetable template");
            UpdateActionResponse updateActionResponse = new UpdateActionResponseImpl();
            return new ResponseEntity<>(updateActionResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new UpdateActionResponseError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping({"/assign"})
    public ResponseEntity<UpdateActionResponse> createTimetableAssignment(AssignTimetableTemplatesRequest assignTimetableTemplatesRequest) {
        try {
            System.out.println("Assign timetable template: " + assignTimetableTemplatesRequest);
            UpdateActionResponseImpl updateActionResponse = new UpdateActionResponseImpl();
            return new ResponseEntity<>(updateActionResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new UpdateActionResponseError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping({"/assign"})
    public ResponseEntity<UpdateActionResponse> removeTimetableAssignment(AssignTimetableTemplatesRequest assignTimetableTemplatesRequest) {
        try {
            System.out.println("Unassign timetable template: " + assignTimetableTemplatesRequest);
            UpdateActionResponseImpl updateActionResponse = new UpdateActionResponseImpl();
            return new ResponseEntity<>(updateActionResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new UpdateActionResponseError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
