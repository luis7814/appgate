package com.appgate.operation.service;

import com.appgate.operation.data.SessionData;
import com.appgate.operation.repository.SessionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class SessionServiceTest {

    @Mock
    SessionRepository sessionRepository;

    @InjectMocks
    SessionService sessionService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSessionGenerate() throws Exception {
        SessionData result = sessionService.sessionGenerate();
        //Assert.assertEquals(new SessionData(), result);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindById() throws Exception {
        SessionData result = sessionService.findById("idSession");
        Assert.assertEquals(new SessionData(), result);
    }

    @Test
    public void testFindAll() throws Exception {
        List<SessionData> result = sessionService.findAll();
        Assert.assertEquals(0, result.size());
    }
}
