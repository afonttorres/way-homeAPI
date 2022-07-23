package com.hackaton.wayhome.services.client.publisher;

import com.hackaton.wayhome.dtos.client.publisher.PublisherResDto;

import java.util.List;

public interface IPublisherService {
    List<PublisherResDto> getAll();

    PublisherResDto getById(Long id);
}
