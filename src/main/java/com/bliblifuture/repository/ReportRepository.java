package com.bliblifuture.repository;

import com.bliblifuture.model.Report;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,String> {
    Report findByDate(LocalDate date);
}
