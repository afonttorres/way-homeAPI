package com.hackaton.wayhome.services.client.publisher;

import com.hackaton.wayhome.dtos.client.publisher.res.PublisherResDto;
import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.mappers.PublisherMapper;
import com.hackaton.wayhome.repositories.IPublisherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService implements IPublisherService {

    IPublisherRepository publisherRepository;

    public PublisherService(IPublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherResDto> getAll() {
        List<PublisherResDto> res = new ArrayList<>();
        var publishers =  publisherRepository.findAll();
        return new PublisherMapper().mapMultiplePublishersToRes(publishers);
    }

    @Override
    public PublisherResDto getById(Long id) {
        var publisher = publisherRepository.findById(id);
        if(publisher.isEmpty()) throw new NotFoundException("Publisher Not Found", "PB-404");
        return  new PublisherMapper().mapPublisherToRes(publisher.get());
    }
}
