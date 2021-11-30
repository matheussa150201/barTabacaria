package com.barTabacaria.repository;

import com.barTabacaria.entity.Essencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssenciaRepository extends JpaRepository<Essencia, Integer> {
}
