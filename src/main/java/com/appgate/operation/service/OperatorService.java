package com.appgate.operation.service;

import com.appgate.operation.data.OperatorData;
import com.appgate.operation.data.ValueData;
import com.appgate.operation.repository.OperatorRepository;
import com.appgate.operation.repository.ValueRepository;
import com.appgate.operation.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private ValueRepository valueRepository;

    private List<ValueData> operatorDatas;
    private Float result;

    @Transactional
    public OperatorData registerResult(OperatorData operatorData) {

        fieldValidation(operatorData);

        operatorDatas = valueRepository.findByIdSession(operatorData.getIdSession());

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

    }
}
