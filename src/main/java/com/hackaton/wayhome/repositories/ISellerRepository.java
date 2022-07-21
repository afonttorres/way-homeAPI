package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISellerRepository extends JpaRepository<Seller, Long> {
}
