package org.example.infra.repositories.jpa;

import org.example.infra.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<StopEntity, Long> {}
