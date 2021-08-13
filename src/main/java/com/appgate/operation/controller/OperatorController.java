package com.appgate.operation.controller;

import com.appgate.operation.data.OperatorData;
import com.appgate.operation.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appgate")
public class OperatorController {

    Logger logger = LoggerFactory.getLogger(OperatorController.class);

    @Autowired
    private OperatorService operatorService;


    @GetMapping("/operator")
    public List<OperatorData> findAll() {
        logger.info("Inicia la consulta de todas operaciones realizadas");
        return operatorService.findAll();
    }

    @GetMapping("/operator/{idSession}")
    public List<OperatorData> findById(@PathVariable String idSession) {
        logger.info("Inicia la consulta de las operaciones realizadas por sesion");
        return operatorService.findByIdSession(idSession);
    }

    @PostMapping("/operator")
    public OperatorData registerResult(@RequestBody OperatorData operatorData) {
        logger.info("Inicia el registro del resultado con la operacion expuesta");
        return operatorService.registerResult(operatorData);
    }

}
