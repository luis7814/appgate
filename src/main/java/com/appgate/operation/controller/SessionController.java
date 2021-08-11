package com.appgate.operation.controller;

import com.appgate.operation.data.SessionData;
import com.appgate.operation.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/session")
    public List<SessionData> findAll() {
        return sessionService.findAll();
    }

    @PostMapping("/session")
    public SessionData sessionGenerate() {
        return sessionService.sessionGenerate();
    }
}
