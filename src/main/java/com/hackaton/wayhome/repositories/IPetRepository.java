package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Pet, Long> {
}
