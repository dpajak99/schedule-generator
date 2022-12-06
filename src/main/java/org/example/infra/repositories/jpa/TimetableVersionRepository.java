package org.example.infra.repositories.jpa;

import org.example.infra.entity.TimetableVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableVersionRepository extends JpaRepository<TimetableVersionEntity, Long> {}
