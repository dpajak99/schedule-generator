package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.RouteModel;
import org.example.models.schedule.StopModel;

import java.util.List;

@Getter
@Setter
public class RouteConfig {
    private RouteModel route;
    
    private List<StopModel> stops;
}
