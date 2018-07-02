/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.service;

import com.akjn.bookingboss.domain.EventProducts;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author AkhilJayan
 */
public class EventDto {
    private Long eventId;
    private Date eventDate;
    private Collection<EventProductsDto> productCollection;
    
    

    public EventDto(Long eventId, Date eventDate, Collection<EventProductsDto> productCollection) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.productCollection = productCollection;
    }

    public EventDto() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Collection<EventProductsDto> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<EventProductsDto> productCollection) {
        this.productCollection = productCollection;
    }

    
}
