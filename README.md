# Booking-boss Test : Rest web service using Spring Boot

### API's
##
1.Add list of products.
  - POST ("/api/save-products")
  - @param : List<ProductDto> (@RequestBody)
```sh
[{
    "name": "",
    "unitPrice": "",
    "eventCollection" : [] (Empty while initial creation)
}]
```
##
2.Add list of Events.
  - POST ("/api/save-events")
  - @param : List<EventDto> (@RequestBody)
```sh
[{
    "name": "",
    "eventDate": "",
    "productCollection" : []  (Empty while initial creation)
}]
```
##
3.Put products to event.
  - POST("/api/put-products")
  - @Param: EventDto (@RequestBody)
```sh
{
  "id": "(string) unique id of the event",
  "timestamp": "(timestamp) utc timestamp of the event",
  "products": [
    {
      "id": "(long) id of the product",
      "name": "(string) name of the product",
      "quantity": "(integer) quantity of the product",
      "sale_amount": "(double) total sale amount"
    }
  ]
}
```
##
4.Get Event details from id.
  - GET("/event/{id}")
  - @Param: id (PathVariable)


##
5.Get Event details from name.
  - GET("/event/{name}")
  - @Param: name (PathVariable)
##
### Summary
- Spring Boot
- Hybernate
- JPA
- MySql 
- DB: products_schema
