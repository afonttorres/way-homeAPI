package com.hackaton.wayhome.repositories;

import com.hackaton.wayhome.models.picture.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPictureRepository extends JpaRepository<Picture, Long> {
}
