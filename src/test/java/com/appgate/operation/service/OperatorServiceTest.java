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

import java.util.Arrays;
import java.util.List;

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
        when(valueRepository.findByIdSession(anyString())).thenReturn(Arrays.<ValueData>asList(new ValueData()));

        OperatorData result = operatorService.registerResult(new OperatorData());
        Assert.assertEquals(new OperatorData(), result);
    }

    @Test
    public void testFindAll() throws Exception {
        List<OperatorData> result = operatorService.findAll();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindByIdSession() throws Exception {
        when(operatorRepository.findByIdSession(anyString())).thenReturn(Arrays.<OperatorData>asList(new OperatorData()));

        List<OperatorData> result = operatorService.findByIdSession("idSession");
        Assert.assertEquals(Arrays.<OperatorData>asList(new OperatorData()), result);
    }
}
