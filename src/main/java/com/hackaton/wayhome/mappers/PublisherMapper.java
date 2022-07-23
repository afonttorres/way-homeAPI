package com.hackaton.wayhome.mappers;


import com.hackaton.wayhome.dtos.client.publisher.res.PublisherNestedResDto;
import com.hackaton.wayhome.dtos.client.publisher.req.PublisherPostReqDto;
import com.hackaton.wayhome.dtos.client.publisher.req.PublisherPutReqDto;
import com.hackaton.wayhome.dtos.client.publisher.res.PublisherResDto;
import com.hackaton.wayhome.models.client.Publisher;

public class PublisherMapper {
    public Publisher mapPostReqToUser(PublisherPostReqDto req){
        var publisher = new Publisher();
        publisher.setName(req.getName());
        publisher.setSurname(req.getSurname());
        publisher.setUsername(req.getUsername());
        publisher.setEmail(req.getEmail());
        publisher.setPassword(req.getPassword());
        return publisher;
    }

    public Publisher mapPutReqToUser(PublisherPutReqDto req, Publisher foundPublisher){
        var publisher = foundPublisher;
        publisher.setAvatar(req.getAvatar());
        publisher.setName(req.getName());
        publisher.setSurname(req.getSurname());
        publisher.setUsername(req.getUsername());
        publisher.setPhone(req.getPhone());
        publisher.setCountry(req.getCountry());
        publisher.setCitty(req.getCitty());
        return publisher;
    }

    public PublisherNestedResDto mapPublisherToNestedRes(Publisher publisher){
        var res = new PublisherNestedResDto();
        res.setId(publisher.getId());
        res.setAvatar(publisher.getAvatar());
        res.setName(publisher.getName());
        res.setSurname(publisher.getSurname());
        res.setUsername(publisher.getUsername());
        res.setEmail(publisher.getEmail());
        res.setPhone(publisher.getPhone());
        res.setCreatedDate(publisher.getCreatedDate());
        return res;
    }

    public PublisherResDto mapPublisherToRes(Publisher publisher){
        var res = new PublisherResDto();
        res.setId(publisher.getId());
        res.setAvatar(publisher.getAvatar());
        res.setName(publisher.getName());
        res.setSurname(publisher.getSurname());
        res.setUsername(publisher.getUsername());
        res.setEmail(publisher.getEmail());
        res.setPhone(publisher.getPhone());
        res.setCountry(publisher.getCountry());
        res.setCitty(publisher.getCitty());
        res.setCreatedDate(publisher.getCreatedDate());
        return res;
    }
}
