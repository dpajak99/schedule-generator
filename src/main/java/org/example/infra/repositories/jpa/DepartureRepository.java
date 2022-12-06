package org.example.infra.repositories.jpa;


import org.example.infra.entity.DepartureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartureRepository extends JpaRepository<DepartureEntity, Long> {}
