package org.example.builders;

import lombok.Getter;
import lombok.Setter;
import org.example.models.schedule.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class SingleTimetableData implements TimetableData {
    StopModel stop;
    RouteModel route;
    
    RouteConnectionModel routeConnection;
    
    List<RouteConnectionModel> routeConnections;
    List<SymbolModel> destinations = new ArrayList<>();
    
    public LineModel getLine() {
        return route.getLine();
    }
    
    public List<RouteConnectionModel> getRouteConnectionsFromNow() {
        int index = routeConnections.indexOf(routeConnection);
        return routeConnections.subList(index, routeConnections.size());
    }
    
    public List<String> getCitiesFromNow() {
        return getRouteConnectionsFromNow().stream().map(RouteConnectionModel::getStop).map(StopModel::getCity).distinct().toList();
    }
}
