/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.service;

import java.util.List;


/**
 *
 * @author AkhilJayan
 */
public interface IEventAppService {
    
    EventProductsDto createEventProducts(EventProductsDto evntProducts);
    
    EventDto getEventById(Long id);
    
    EventDto getEventByName(String name);
    
    List<ProductDto> getAllProducts();
    
    EventDto createEvent(EventDto event);
    
    ProductDto ctrateProduct(ProductDto product);
    
    String putProductsToCurrentEvent(EventDto event);

}
