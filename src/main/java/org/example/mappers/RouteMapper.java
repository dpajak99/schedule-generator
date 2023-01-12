package org.example.mappers;

import org.example.infra.entity.RouteEntity;
import org.example.models.schedule.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    final LineMapper lineMapper;

    @Autowired
    public RouteMapper(LineMapper lineMapper) {
        this.lineMapper = lineMapper;
    }

    public RouteModel mapToModel(RouteEntity routeEntity) {
        RouteModel routeModel = new RouteModel();
        routeModel.setId(routeEntity.getId());
        routeModel.setLine(lineMapper.mapToModel(routeEntity.getLine()));
        routeModel.setDescription(routeEntity.getDescription());
        routeModel.setName(routeEntity.getName());
//        routeModel.setDateStart(routeEntity.getDateStart());
//        routeModel.setDateEnd(routeEntity.getDateEnd());
        routeModel.setComments(routeEntity.getComments());
        return routeModel;
    }
    
    public RouteEntity mapToEntity(RouteModel routeModel) {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setId(routeModel.getId());
        routeEntity.setLine(lineMapper.mapToEntity(routeModel.getLine()));
        routeEntity.setDescription(routeModel.getDescription());
//        routeEntity.setDateStart(routeModel.getDateStart());
//        routeEntity.setDateEnd(routeModel.getDateEnd());
        routeEntity.setComments(routeModel.getComments());
        return routeEntity;
    }
}
