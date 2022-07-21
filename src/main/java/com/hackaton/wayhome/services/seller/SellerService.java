package com.hackaton.wayhome.services.seller;

import com.hackaton.wayhome.repositories.ISellerRepository;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements ISellerService{

    ISellerRepository sellerRepository;

    public SellerService(ISellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

}
