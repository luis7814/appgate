package com.appgate.operation.service;

import com.appgate.operation.data.OperatorData;
import com.appgate.operation.data.SessionData;
import com.appgate.operation.data.ValueData;
import com.appgate.operation.repository.OperatorRepository;
import com.appgate.operation.repository.ValueRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class ValueServiceTest {

    @Mock
    ValueRepository valueRepository;

    @Mock
    OperatorRepository operatorRepository;

    @Mock
    SessionService sessionService;

    @InjectMocks
    ValueService valueService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValueRegister() throws Exception {
        when(operatorRepository.findFirstByOrderByIdValueAsc()).thenReturn(operatorData());
        when(sessionService.findById(anyString())).thenReturn(sessionData());

        ValueData result = valueService.valueRegister(valueData());
        Assert.assertEquals(sessionData().getIdSession(), result.getIdSession());
    }

    @Test
    public void testFindAll() throws Exception {
        List<ValueData> result = valueService.findAll();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindById() throws Exception {
        when(valueRepository.findByIdSession(anyString())).thenReturn(Arrays.<ValueData>asList(new ValueData()));

        List<ValueData> result = valueService.findById("idSession");
        Assert.assertEquals(Arrays.<ValueData>asList(new ValueData()), result);
    }

    private SessionData sessionData() {
        SessionData sessionData = new SessionData();
        sessionData.setDate(new Date());
        sessionData.setIdSession("123-456");

        return sessionData;
    }

    private ValueData valueData() {
        ValueData valueData = new ValueData();
        valueData.setValue(1);
        valueData.setIdSession("123-456");

        return valueData;
    }

    private OperatorData operatorData() {
        OperatorData operatorData = new OperatorData();
        operatorData.setOperator("SUMA");
        operatorData.setIdSession("123-456");
        operatorData.setIdValue(0);

        return operatorData;
    }
}
