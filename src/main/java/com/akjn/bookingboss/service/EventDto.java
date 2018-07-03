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
    private String name;
    private Date eventDate;
    private Collection<ProductDto> productCollection;
    
    

    public EventDto(Long eventId,String name, Date eventDate, Collection<ProductDto> productCollection) {
        this.eventId = eventId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Collection<ProductDto> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<ProductDto> productCollection) {
        this.productCollection = productCollection;
    }

    
}
