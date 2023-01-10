package org.example.models.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RouteModel {
    private Long id;
    private LineModel line;
    private String description;
    private Date dateStart;
    private Date dateEnd;
    private String comments;
}
