package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IHousingRepository extends JpaRepository<Housing, Long> {
    @Query("select h from Housing h " +
            "where upper(h.title) like upper(concat('%', :search, '%')) or upper(h.description) like upper(concat('%', :search, '%')) or upper(h.category) like upper(concat('%', :search, '%')) or upper(h.animal) like upper(concat('%', :search, '%')) or upper(h.location) like upper(concat('%', :search, '%'))")
    List<Housing> findByTitleContainsOrDescriptionContainsOrCategoryContainsOrAnimalContainsOrLocationContainsAllIgnoreCase(@Param("search") String search);



}
