package org.example.infra.services.jpa.impl;

import org.example.infra.repositories.jpa.LineRepository;
import org.example.infra.services.jpa.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineServiceImpl implements LineService {
    private LineRepository lineRepository;

    @Autowired
    public LineServiceImpl(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }
}
