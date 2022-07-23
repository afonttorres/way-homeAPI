package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.spec.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISpecRepository extends JpaRepository<Spec, Long> {

    @Query("select s from Spec s where s.housing.id = :id")
    List<Spec> findByHousingId(@Param("id") Long id);
}
