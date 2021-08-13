package com.appgate.operation.service;

import com.appgate.operation.data.OperatorData;
import com.appgate.operation.data.ValueData;
import com.appgate.operation.repository.OperatorRepository;
import com.appgate.operation.repository.ValueRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.mockito.Mockito.*;

public class OperatorServiceTest {

    @Mock
    OperatorRepository operatorRepository;

    @Mock
    ValueRepository valueRepository;

    @Mock
    List<ValueData> operatorDatas;

    @InjectMocks
    OperatorService operatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterResult() throws Exception {
        when(valueRepository.findByIdSession(anyString())).thenReturn(valueDatas());

        OperatorData result = operatorService.registerResult(operatorData());
        Assert.assertEquals(operatorData().getIdSession(), result.getIdSession());
    }

    @Test
    public void testFindAll() throws Exception {
        List<OperatorData> result = operatorService.findAll();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindByIdSession() throws Exception {
        when(operatorRepository.findByIdSession(anyString())).thenReturn(operatorDatas());

        List<OperatorData> result = operatorService.findByIdSession("idSession");
        Assert.assertEquals(operatorDatas(), result);
    }

    public List<ValueData> valueDatas() {

        List<ValueData> valueDatas = new ArrayList<>();
        ValueData valueData = new ValueData();
        valueData.setValue(1);
        valueData.setIdSession("123-456");
        valueDatas.add(valueData);

        return valueDatas;
    }

    public OperatorData operatorData() {
        OperatorData operatorData = new OperatorData();
        operatorData.setOperator("SUMA");
        operatorData.setIdSession("123-456");

        return operatorData;
    }

    public List<OperatorData> operatorDatas() {

        List<OperatorData> operatorDatas = new ArrayList<>();
        operatorDatas.add(operatorData());

        return operatorDatas;
    }
}
