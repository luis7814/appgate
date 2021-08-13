package com.appgate.operation.service;

import com.appgate.operation.controller.exception.ValidateException;
import com.appgate.operation.data.OperatorData;
import com.appgate.operation.data.ValueData;
import com.appgate.operation.repository.OperatorRepository;
import com.appgate.operation.repository.ValueRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ValueService {

    Logger logger = LoggerFactory.getLogger(ValueService.class);

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private SessionService sessionService;

    @Transactional
    public ValueData valueRegister(ValueData valueData) {

        logger.info("Se realiza la validacion de los campos necesarios");
        fieldValidation(valueData);

        logger.info("Valida que la sesion este activa y procede a registrar el operando");
        if(StringUtils.isNotBlank(
                sessionService.findById(valueData.getIdSession()).getIdSession())) {

            valueData.setDate(new Date());
            valueData.setIdValue(maxIdValue());

            valueRepository.save(valueData);
        } else {
            throw new ValidateException("La sesion ingresada no se encuentra activa");
        }

        return valueData;
    }

    public List<ValueData> findAll() {
        return valueRepository.findAll();
    }

    public List<ValueData> findById(String idSession) {
        return valueRepository.findByIdSession(idSession);
    }

    private Integer maxIdValue() {
        OperatorData operatorData = operatorRepository.findFirstByOrderByIdValueAsc();
        if(operatorData != null) {
            return operatorData.getIdValue() + 1;
        }
        return 1;
    }

    private void fieldValidation(ValueData valueData) {

        if(StringUtils.isBlank(valueData.getIdSession())) {
            throw new ValidateException("Validate idSession");
        }
        if(valueData.getValue() == null) {
            throw new ValidateException("Validate value is not null");
        }
    }


}
