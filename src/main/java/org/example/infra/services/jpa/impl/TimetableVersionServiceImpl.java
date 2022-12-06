package org.example.infra.services.jpa.impl;

import org.example.infra.repositories.jpa.TimetableVersionRepository;
import org.example.infra.services.jpa.TimetableVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableVersionServiceImpl implements TimetableVersionService {
    private TimetableVersionRepository timetableVersionRepository;

    @Autowired
    public TimetableVersionServiceImpl(TimetableVersionRepository timetableVersionRepository) {
        this.timetableVersionRepository = timetableVersionRepository;
    }
}
