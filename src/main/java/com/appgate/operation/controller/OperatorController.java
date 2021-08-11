package com.appgate.operation.controller;

import com.appgate.operation.data.OperatorData;
import com.appgate.operation.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;


    @GetMapping("/operator")
    public List<OperatorData> findAll() {
        return operatorService.findAll();
    }

}
