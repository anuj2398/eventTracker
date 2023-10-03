package com.event.eventTracker.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "events")
public class Event {
    private String id;
    private String userId;
    private String eventName;
    //APP_ACCESS,
    //BANNER_CLICK,
    //VIEW_PRODUCTS,
    //SELECT_PRODUCT,
    //ADD_TO_CART,
    //PLACE_ORDER
    private String city;
}
