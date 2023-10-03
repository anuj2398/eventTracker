package com.event.eventTracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.eventTracker.model.Event;
import com.event.eventTracker.model.EventType;
import com.event.eventTracker.repository.EventRepository;
import com.event.eventTracker.service.AnalyticsService;

@RestController
@RequestMapping("/webhook")
public class webHookController {
    @Autowired
    private  AnalyticsService analyticsService;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
    
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Event processing started");
    }
    @GetMapping("/percentage/{eventName}")
    public double getPercentageOfUsersInStage(@PathVariable String eventName) {
        return analyticsService.getPercentageOfUsersInStage(eventName);
    }

    @GetMapping("/performance/{city}")
    public double getPerformanceByCity(@PathVariable String city) {
        return analyticsService.getPerformanceByCity(city);
    }
    @PostMapping("/events")
    public void receiveEvent(@RequestBody Event event) {
        eventRepository.save(event);
    }

    
}
