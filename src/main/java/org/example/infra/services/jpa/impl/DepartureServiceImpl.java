package org.example.infra.services.jpa.impl;

import org.example.infra.repositories.jpa.DepartureRepository;
import org.example.infra.services.jpa.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartureServiceImpl implements CompanyService {
    private DepartureRepository departureRepository;

    @Autowired
    public DepartureServiceImpl(DepartureRepository departureRepository) {
        this.departureRepository = departureRepository;
    }
}
