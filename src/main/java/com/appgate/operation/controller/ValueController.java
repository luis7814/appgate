package com.appgate.operation.controller;

import com.appgate.operation.data.ValueData;
import com.appgate.operation.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/appgate")
public class ValueController {

    @Autowired
    private ValueService valueService;

    @GetMapping("/value")
    public List<ValueData> findAll() {
        return valueService.findAll();
    }

    @GetMapping("/value/{idSession}")
    public List<ValueData> findById(@PathVariable String idSession) {
        return valueService.findById(idSession);
    }

    @PostMapping("/value")
    public ValueData registerValue(@RequestBody ValueData valueData) {
        return valueService.valueRegister(valueData);
    }
}
