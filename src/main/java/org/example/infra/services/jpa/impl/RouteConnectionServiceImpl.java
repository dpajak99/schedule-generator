package org.example.infra.services.jpa.impl;

import org.example.infra.repositories.jpa.RouteConnectionRepository;
import org.example.infra.services.jpa.RouteConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteConnectionServiceImpl implements RouteConnectionService {
    private RouteConnectionRepository routeConnectionRepository;

    @Autowired
    public RouteConnectionServiceImpl(RouteConnectionRepository routeConnectionRepository) {
        this.routeConnectionRepository = routeConnectionRepository;
    }
}
