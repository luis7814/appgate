package com.appgate.operation.service;

import com.appgate.operation.data.SessionData;
import com.appgate.operation.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Transactional
    public SessionData sessionGenerate() {
        String session = java.util.UUID.randomUUID().toString();

        SessionData sessionData = new SessionData();
        sessionData.setIdSession(session);
        sessionData.setDate(new Date());

        sessionRepository.save(sessionData);

        return sessionData;
    }

    public SessionData findById(String idSession) {

        return Optional.ofNullable(sessionRepository.findById(idSession))
                .get()
                .orElse(new SessionData());

    }

    public List<SessionData> findAll() {

        return (List<SessionData>) sessionRepository.findAll();
    }
}
