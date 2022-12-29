package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Mesaj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesajRepository extends JpaRepository<Mesaj,Long> {
}
