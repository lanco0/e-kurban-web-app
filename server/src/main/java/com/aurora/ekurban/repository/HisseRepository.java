package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Hisse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HisseRepository extends JpaRepository<Hisse, Long> {
}
