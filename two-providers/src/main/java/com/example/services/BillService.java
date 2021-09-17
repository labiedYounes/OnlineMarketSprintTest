package com.example.services;

import com.example.models.Bill;
import com.example.repositories.BillRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService extends AbstractService<Bill> {
    public BillService(BillRepository mainRepository){
        super(mainRepository);
    }
}
