/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.controller;

import com.akjn.bookingboss.exception.ResourceNotFoundException;
import com.akjn.bookingboss.domain.Products;
import com.akjn.bookingboss.service.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import com.akjn.bookingboss.service.ProductRepository;
import com.akjn.bookingboss.service.IEventAppService;
import com.akjn.bookingboss.service.ProductDto;

/**
 *
 * @author AkhilJayan
 */
@RestController
@RequestMapping("/api")
public class BookingBossController {

    @Autowired
    ProductRepository noteRepository;
    
    @Autowired
    IEventAppService _appService;
    
     @PostMapping("/save-products")
     public String createListProducts(@Valid @RequestBody List<ProductDto> products) {
         products.forEach((p) -> {
             _appService.ctrateProduct(p);
        });
        return "All Products Saved";
    }
     
     
     @PostMapping("/save-events")
     public String createListEvents(@Valid @RequestBody List<EventDto> events) {
         events.forEach((e) -> {
             _appService.createEvent(e);
        });
        return "All Events Saved";
    }
    
    @PostMapping("/event-create")
    public EventDto createEvent(@Valid @RequestBody EventDto event) {
        return _appService.createEvent(event);
    }
    
    @PostMapping("/product-create")
    public ProductDto createProduct(@Valid @RequestBody ProductDto product) {
        return _appService.ctrateProduct(product);
    }
    
    @PostMapping("/put-products")
    public String addProductsToEvent(@Valid @RequestBody EventDto event){
        return _appService.putProductsToCurrentEvent(event);
    }
    
    

//    @GetMapping("/products")
//    public List<Products> getAllProducts() {
//        return _appService.findAll();
//    }
    @GetMapping("/all-products")
    public List<ProductDto> getAllProducts() {
        return _appService.getAllProducts();
    }

    @GetMapping("/event/{id}")
    public EventDto getEventById(@PathVariable(value = "id") Long eventId) {
        return _appService.getEventById(eventId);
    }
    
    @GetMapping("/event-name/{name}")
    public EventDto getEventByName(@PathVariable(value = "name") String name) {
        return _appService.getEventByName(name);
    }

}
