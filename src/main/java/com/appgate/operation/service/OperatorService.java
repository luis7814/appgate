package com.appgate.operation.service;

import com.appgate.operation.controller.exception.ValidateException;
import com.appgate.operation.data.OperatorData;
import com.appgate.operation.data.ValueData;
import com.appgate.operation.repository.OperatorRepository;
import com.appgate.operation.repository.ValueRepository;
import com.appgate.operation.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperatorService {

    Logger logger = LoggerFactory.getLogger(OperatorService.class);

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private ValueRepository valueRepository;

    private List<ValueData> operatorDatas;
    private Float result;

    @Transactional
    public OperatorData registerResult(OperatorData operatorData) {

        logger.info("Se realiza la validacion de los campos necesarios");
        fieldValidation(operatorData);

        logger.info("Devuelve todos los operandos registrados para la sesion ingresada");
        operatorDatas = valueRepository.findByIdSession(operatorData.getIdSession());

        logger.info("Realiza la operacion correspondiente con los operandos registrados anteriormente");
        if(operatorDatas.size() > 0) {
            result = Float.valueOf(0);
            operatorDatas.forEach((value) -> {
                if(operatorData.getOperator().equals(Constants.OPERATOR_SUM)) {
                    result = result + value.getValue();
                }
                if(operatorData.getOperator().equals(Constants.OPERATOR_SUBTRACTION)) {
                    result = value.getValue() - result;
                }
                if(operatorData.getOperator().equals(Constants.OPERATOR_MULTIPLICATION)) {
                    result = (result < 1 ? 1 : result) * value.getValue();
                }
                if(operatorData.getOperator().equals(Constants.OPERATOR_DIVISION)) {
                    result = value.getValue() / (result < 1 ? 1 : result);
                }
            });

            operatorData.setDate(new Date());
            operatorData.setResult(result);
            operatorData.setIdValue(operatorDatas.get(0).getIdValue());

            operatorRepository.save(operatorData);
        }else {
            throw new ValidateException("Debe ingresar una session valida");
        }

        return operatorData;
    }

    public List<OperatorData> findAll() {
        return operatorRepository.findAll();
    }

    public List<OperatorData> findByIdSession(String idSession) {
        return operatorRepository.findByIdSession(idSession);
    }

    private void fieldValidation(OperatorData operatorData) {

        if(StringUtils.isBlank(operatorData.getIdSession())) {
            throw new ValidateException("Debe ingresar una sesión");
        }

        if(StringUtils.isBlank(validateOperator(operatorData.getOperator()))) {
            throw new ValidateException("Debe ingresar un operador valido : SUMA, RESTA, MULTIPLICACION O DIVISION");
        }

    }

    private String validateOperator(String operator) {

        if(StringUtils.isBlank(operator)) {
            throw new ValidateException("Debe ingresar un operador");
        }

        return Constants.OPERATOR_LIST.stream()
                .filter(value -> value.equals(operator))
                .findAny()
                .orElse("");

    }
}
