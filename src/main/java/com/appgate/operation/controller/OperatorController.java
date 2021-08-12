package com.appgate.operation.controller;

import com.appgate.operation.data.OperatorData;
import com.appgate.operation.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appgate")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;


    @GetMapping("/operator")
    public List<OperatorData> findAll() {
        return operatorService.findAll();
    }

    @GetMapping("/operator/{idSession}")
    public List<OperatorData> findById(@PathVariable String idSession) {
        return operatorService.findByIdSession(idSession);
    }

    @PostMapping("/operator")
    public OperatorData registerResult(@RequestBody OperatorData operatorData) {
        return operatorService.registerResult(operatorData);
    }

}
