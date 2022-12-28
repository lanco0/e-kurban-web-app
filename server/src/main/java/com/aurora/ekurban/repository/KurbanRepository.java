package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Kurban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KurbanRepository extends JpaRepository<Kurban, Long> {
}
