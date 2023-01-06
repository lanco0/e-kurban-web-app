package com.aurora.ekurban.repository;

import com.aurora.ekurban.domain.Hissedar;
import com.aurora.ekurban.domain.Kurban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface HissedarRepository extends JpaRepository<Hissedar, Long> , JpaSpecificationExecutor<Hissedar> {
    Optional<Hissedar> findHissedarByTel(String tel);
}
