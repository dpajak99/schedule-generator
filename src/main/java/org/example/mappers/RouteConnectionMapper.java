package org.example.mappers;

import org.example.infra.entity.RouteConnectionEntity;
import org.example.models.schedule.RouteConnectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RouteConnectionMapper {
    final RouteMapper routeMapper;
    final StopMapper stopMapper;

    @Autowired
    public RouteConnectionMapper(RouteMapper routeMapper, StopMapper stopMapper) {
        this.routeMapper = routeMapper;
        this.stopMapper = stopMapper;
    }
    
    public List<RouteConnectionModel> mapToModels(List<RouteConnectionEntity> routeConnectionEntities) {
        return routeConnectionEntities.stream().map(this::mapToModel).collect(Collectors.toList());
    }

    public RouteConnectionModel mapToModel(RouteConnectionEntity routeConnectionEntity) {
        RouteConnectionModel routeConnectionModel = new RouteConnectionModel();
        routeConnectionModel.setId(routeConnectionEntity.getId());
        routeConnectionModel.setRoute(routeMapper.mapToModel(routeConnectionEntity.getRoute()));
        routeConnectionModel.setStop(stopMapper.mapToModel(routeConnectionEntity.getStop()));
        routeConnectionModel.setIsOptional(routeConnectionEntity.getIsOptional());
        routeConnectionModel.setLp(routeConnectionEntity.getLp());
        routeConnectionModel.setDescription(routeConnectionEntity.getDescription());
        return routeConnectionModel;
    }
    
    public RouteConnectionEntity mapToEntity(RouteConnectionModel routeConnectionModel) {
        RouteConnectionEntity routeConnectionEntity = new RouteConnectionEntity();
        routeConnectionEntity.setId(routeConnectionModel.getId());
        routeConnectionEntity.setRoute(routeMapper.mapToEntity(routeConnectionModel.getRoute()));
        routeConnectionEntity.setStop(stopMapper.mapToEntity(routeConnectionModel.getStop()));
        routeConnectionEntity.setIsOptional(routeConnectionModel.getIsOptional());
        routeConnectionEntity.setLp(routeConnectionModel.getLp());
        routeConnectionEntity.setDescription(routeConnectionModel.getDescription());
        return routeConnectionEntity;
    }
}
