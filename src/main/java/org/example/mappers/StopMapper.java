package org.example.mappers;

import org.example.infra.entity.StopEntity;
import org.example.models.schedule.StopModel;
import org.springframework.stereotype.Component;

@Component
public class StopMapper {
    StopModel mapToModel(StopEntity stopEntity) {
        StopModel stopModel = new StopModel();
        stopModel.setId(stopEntity.getId());
        stopModel.setName(stopEntity.getName());
        stopModel.setSearchName(stopEntity.getSearchName());
        stopModel.setDestinations(stopEntity.getDestinations());
        stopModel.setCity(stopEntity.getCity());
        stopModel.setLat(stopEntity.getLat());
        stopModel.setLng(stopEntity.getLng());
        return stopModel;
    }
    
    StopEntity mapToEntity(StopModel stopModel) {
        StopEntity stopEntity = new StopEntity();
        stopEntity.setId(stopModel.getId());
        stopEntity.setName(stopModel.getName());
        stopEntity.setSearchName(stopModel.getSearchName());
        stopEntity.setDestinations(stopModel.getDestinations());
        stopEntity.setCity(stopModel.getCity());
        stopEntity.setLat(stopModel.getLat());
        stopEntity.setLng(stopModel.getLng());
        return stopEntity;
    }
}
