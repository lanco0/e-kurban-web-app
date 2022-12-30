package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Kurban;
import com.aurora.ekurban.enumeration.KurbanCins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KurbanRepository extends JpaRepository<Kurban, Long> {
    List<Kurban> findAllByCins(KurbanCins kurbanCins);

}
