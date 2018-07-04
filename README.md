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
    "eventId": "(string) unique id of the event",
    "name": "(string) name of the event",
    "eventDate": "(timestamp) utc timestamp of the event",
    "productCollection": [
		{
	        "productId": "(long) id of the product",
	        "name": "(string) name of the product",
	        "quantity": "(integer) quantity of the product"
		}
		...
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
