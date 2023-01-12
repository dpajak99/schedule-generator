package org.example.infra.services.jpa.impl;

import org.example.infra.entity.RouteConnectionEntity;
import org.example.infra.repositories.jpa.RouteConnectionRepository;
import org.example.infra.services.jpa.RouteConnectionService;
import org.example.mappers.RouteConnectionMapper;
import org.example.models.schedule.RouteConnectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteConnectionServiceImpl implements RouteConnectionService {
    final RouteConnectionRepository routeConnectionRepository;
    
    final RouteConnectionMapper routeConnectionMapper;

    @Autowired
    public RouteConnectionServiceImpl(RouteConnectionRepository routeConnectionRepository, RouteConnectionMapper routeConnectionMapper) {
        this.routeConnectionRepository = routeConnectionRepository;
        this.routeConnectionMapper = routeConnectionMapper;
    }

    @Override
    public List<RouteConnectionModel> getRouteConnectionsByRouteId(Long routeId) {
        List<RouteConnectionEntity> routeConnectionEntities = routeConnectionRepository.findAllByRouteIdOrderByLp(routeId);
        return routeConnectionMapper.mapToModels(routeConnectionEntities);
    }
}
