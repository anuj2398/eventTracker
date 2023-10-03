package com.event.eventTracker.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.event.eventTracker.model.Event;

public interface EventRepository extends MongoRepository<Event,String>{
    @Query("{ 'eventName' : ?0, 'city' : ?1 }")
    long countByEventNameAndCity(String eventName, String city);

    @Query("{ 'eventName' : ?0 }")
    long countDistinctUsersByEventName(String eventName);

    @Query("{ 'city' : ?0 }")
    long countDistinctUsersByCity(String city);

    long count(); // MongoDB specific count query for total users

}
