package com.appgate.operation.service;

import com.appgate.operation.data.SessionData;
import com.appgate.operation.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public SessionData sessionGenerate() {
        String session = java.util.UUID.randomUUID().toString();

        SessionData sessionData = new SessionData();
        sessionData.setIdSession(session);
        sessionData.setDate(new Date());

        sessionRepository.save(sessionData);

        return sessionData;
    }

    public List<SessionData> findAll() {
        return (List<SessionData>) sessionRepository.findAll();
    }
}
