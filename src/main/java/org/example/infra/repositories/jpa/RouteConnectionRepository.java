package org.example.infra.repositories.jpa;

import org.example.infra.entity.RouteConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteConnectionRepository extends JpaRepository<RouteConnectionEntity, Long> {
    List<RouteConnectionEntity> findAllByRouteIdOrderByLp(Long routeId);
}
