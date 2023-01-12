package org.example.infra.services.jpa.impl;

import org.example.infra.entity.RouteEntity;
import org.example.infra.repositories.jpa.RouteRepository;
import org.example.infra.services.jpa.RouteService;
import org.example.mappers.RouteMapper;
import org.example.models.schedule.RouteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    final RouteRepository routeRepository;
    
    final RouteMapper routeMapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    @Override
    public RouteModel getRouteById(Long id) {
        Optional<RouteEntity> routeEntity = routeRepository.findById(id);
        return routeMapper.mapToModel(routeEntity.get());
    }
}
