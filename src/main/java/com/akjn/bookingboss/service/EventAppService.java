/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.service;

import com.akjn.bookingboss.domain.EventProducts;
import com.akjn.bookingboss.domain.Events;
import com.akjn.bookingboss.domain.Products;
import com.akjn.bookingboss.exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AkhilJayan
 */
@Service
public class EventAppService implements IEventAppService {

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    EventRepository eventRepository;
    
    @Autowired
    EventProductsRepository eventProductRepository;

    @Override
    public EventProductsDto createEventProducts(EventProductsDto evntProducts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EventDto getEventById(Long id) {
        Events evnt = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
        return mapToEventDto(evnt);
    }
    
    @Override
    public EventDto getEventByName(String name) {
        Events evnt = eventRepository.findAll().stream().filter(n -> name.equals(n.getName())).findFirst().orElseThrow(() -> new ResourceNotFoundException("Event", "name", name));
        return mapToEventDto(evnt);
    }

    @Override
    public EventDto createEvent(EventDto event) {
        Events evnt = mapToEventDomain(event);
        Events e = eventRepository.save(evnt);
        return mapToEventDto(e);
    }
    
    @Override
    public String putProductsToCurrentEvent(EventDto event) {
        Events e = eventRepository.findById(event.getEventId()).orElseThrow(() -> new ResourceNotFoundException("Event", "id", event.getEventId()));
        event.getProductCollection().forEach((product) -> {
            EventProducts evpr = new EventProducts(e, product.getProduct(), product.getProductQuantity());
            eventProductRepository.save(evpr);
        });
        return "Products Added Successfully";
    }

    @Override
    public ProductDto ctrateProduct(ProductDto product) {
        Products p = productRepository.save(this.mapProductDtoToDomain(product));
        return mapToProductDto(p);
    }
    
    @Override
    public List<ProductDto> getAllProducts(){
        List<Products> prodts = productRepository.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        prodts.forEach((p) -> {
            dtoList.add(mapToProductDto(p));
        });
        return dtoList;
    }

    public EventProducts mapToEventProductsDomain(EventProductsDto dto){
        return new EventProducts(dto.getEvent(),dto.getProduct(),dto.getProductQuantity());
    }
    
    public EventProductsDto mapToEventProductsDto(EventProducts domain){
        return new EventProductsDto(domain.getId(),domain.getEvent(),domain.getProduct(),domain.getProductQuantity(), domain.getProduct().getUnitPrice() * domain.getProductQuantity());
    }
    
    public Events mapToEventDomain(EventDto dto){
        Collection<EventProducts> eventProduct = new ArrayList<>();
        dto.getProductCollection().forEach((epdto) -> {
            eventProduct.add(mapToEventProductsDomain(epdto));
        });
        Events e = new Events(dto.getName(), dto.getEventDate(), eventProduct);
        return e;
    }
    
    public EventDto mapToEventDto(Events event){
        Collection<EventProductsDto> eventProductDto = new ArrayList<>();
        event.getProductCollection().forEach((epdto) -> {
            eventProductDto.add(mapToEventProductsDto(epdto));
        });
        return new EventDto(event.getEventId(),event.getName(),event.getEventDate(),eventProductDto);
    }
    
    public Products mapProductDtoToDomain(ProductDto dto){
        Collection<EventProducts> eventProduct = new ArrayList<>();
        dto.getEventCollection().forEach((epdto) -> {
            eventProduct.add(mapToEventProductsDomain(epdto));
        });
        return new Products(dto.getName(), dto.getUnitPrice(),eventProduct);
    }
    
    public ProductDto mapToProductDto(Products pdt){
        Collection<EventProductsDto> eventProductDto = new ArrayList<>();
        pdt.getEventCollection().forEach((epdto) -> {
            eventProductDto.add(mapToEventProductsDto(epdto));
        });
        return new ProductDto(pdt.getProductId(), pdt.getName(), pdt.getUnitPrice(), eventProductDto);
    }
    

}
