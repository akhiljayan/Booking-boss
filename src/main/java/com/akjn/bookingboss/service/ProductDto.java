/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.service;

import java.util.Collection;

/**
 *
 * @author AkhilJayan
 */
public class ProductDto {
    private Long productId;
    private String name;
    private Double unitPrice;
    private Collection<EventProductsDto> eventCollection;

    public ProductDto(Long productId, String name, Double unitPrice, Collection<EventProductsDto> eventCollection) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.eventCollection = eventCollection;
    }

    public ProductDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Collection<EventProductsDto> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<EventProductsDto> eventCollection) {
        this.eventCollection = eventCollection;
    }
    
    
}
