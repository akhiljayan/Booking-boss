/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.service;

import com.akjn.bookingboss.domain.Products;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AkhilJayan
 */
@Service
public class EventAppService implements IEventAppService {

    @Autowired
    ProductRepository noteRepository;

    @Override
    public EventProductsDto createEventProducts(EventProductsDto evntProducts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EventDto getEventById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EventDto createEvent(EventDto event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProductDto ctrateProduct(ProductDto product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
