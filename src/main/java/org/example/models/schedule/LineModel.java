package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineModel {
    private Long id;
    
    private TimetableVersionModel timetableVersion;
    
    private String name;
    
    private String comments;
}
