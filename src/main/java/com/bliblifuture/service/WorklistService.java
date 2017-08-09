package com.bliblifuture.service;

import com.bliblifuture.model.Counter;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.repository.CounterRepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.WorklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorklistService {

    @Autowired
    WorklistRepository  worklistRepository;

    @Autowired
    CounterRepository   counterRepository;

    @Autowired
    AuthenticationService   authenticationService;
    public List<StockOpname> findStockOpnameByAssignedTo() { //data request udah dipassing disini
       List<StockOpname> a = worklistRepository.findStockOpnameByAssignedTo((Counter)authenticationService.getAuthenticatedUser());
       return a;
    }
}
