package org.example.infra.repositories.jpa;

import org.example.infra.entity.StopEntity;
import org.example.infra.entity.TimetableTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimetableTemplateRepository  extends JpaRepository<TimetableTemplateEntity, String> {
    @Query("select rtt from RouteTimetableTemplateEntity rtt where rtt.id.route.id = ?1")
    Optional<TimetableTemplateEntity> findByRouteId(Long routeId);
    
    @Query("select ctt from CompanyTimetableTemplate ctt where ctt.id.company.id = ?1")
    TimetableTemplateEntity findByCompanyId(Long companyId);
}
