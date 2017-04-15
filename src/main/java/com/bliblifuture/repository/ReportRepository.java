package com.bliblifuture.repository;

import com.bliblifuture.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReportRepository extends JpaRepository<Report,String> {
    Report findByDate(Date date);
}
