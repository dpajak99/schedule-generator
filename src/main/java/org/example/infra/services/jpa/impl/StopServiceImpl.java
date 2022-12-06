package org.example.infra.services.jpa.impl;

import org.example.infra.repositories.jpa.StopRepository;
import org.example.infra.services.jpa.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopServiceImpl implements StopService {
    private StopRepository stopRepository;

    @Autowired
    public StopServiceImpl(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }
}
