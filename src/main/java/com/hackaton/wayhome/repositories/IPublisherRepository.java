package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.client.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<Publisher, Long> {
}
