package com.event.eventTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.eventTracker.repository.EventRepository;

@Service
public class AnalyticsService {
    private final EventRepository eventRepository;

    @Autowired
    public AnalyticsService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public double getPercentageOfUsersInStage(String eventName) {
        long totalUsers = eventRepository.count();
        long usersInStage = eventRepository.countDistinctUsersByEventName(eventName);
        return calculatePercentage(usersInStage, totalUsers);
    }

    public double getPerformanceByCity(String city) {
        long totalUsers = eventRepository.count();
        long usersInCity = eventRepository.countDistinctUsersByCity(city);
        return calculatePercentage(usersInCity, totalUsers);
    }

    private double calculatePercentage(long numerator, long denominator) {
        return (denominator == 0) ? 0 : ((double) numerator / denominator) * 100;
    }
}
