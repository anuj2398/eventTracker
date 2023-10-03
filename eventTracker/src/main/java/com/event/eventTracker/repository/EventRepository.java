package com.event.eventTracker.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.event.eventTracker.model.Event;

public interface EventRepository extends MongoRepository<Event,String>{
    @Query("{ 'eventName' : ?0, 'city' : ?1 }")
    List<Event> findByEventNameAndCity(String eventName, String city);

    @Query("{ 'eventName' : ?0 }")
    List<Event> findByEventName(String eventName);

    @Query("{ 'city' : ?0 }")
    List<Event> findByCity(String city);

    long countByEventNameAndCity(String eventName, String city);

    long countDistinctUsersByEventName(String eventName);

    long countDistinctUsersByCity(String city);

}
