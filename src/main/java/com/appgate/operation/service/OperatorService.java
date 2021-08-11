package com.appgate.operation.service;

import com.appgate.operation.data.OperatorData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorService {

    public List<OperatorData> findAll() {

        OperatorData operatorData = new OperatorData();
        operatorData.setOperator("Suma");
        operatorData.setIdSession("1");

        List<OperatorData> operatorDatas = new ArrayList<>();
        operatorDatas.add(operatorData);

        return operatorDatas;
    }

    public void insert(OperatorData operatorData) {

    }
}
