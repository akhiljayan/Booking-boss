/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.service;

import com.akjn.bookingboss.domain.Events;
import com.akjn.bookingboss.domain.Products;

/**
 *
 * @author AkhilJayan
 */
public class EventProductsDto {

    private Long id;
    private Events event;   
    private Products product;
    private int productQuantity;
    private Double saleAmount;

    public EventProductsDto(Long id, Events event, Products product, int productQuantity, Double saleAmount) {
        this.id = id;
        this.event = event;
        this.product = product;
        this.productQuantity = productQuantity;
        this.saleAmount = saleAmount;
    }

    public EventProductsDto() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getSaleAmount() {
        return this.product.getUnitPrice() * this.getProductQuantity();
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = this.product.getUnitPrice() * this.getProductQuantity();
    }

    
}
