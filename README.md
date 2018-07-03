Booking-boss Test : Rest web service using Spring Boot

API's

Add list of products
POST ("/api/save-products")
@param : List<ProductDto> (@RequestBody)
[{
    "name": "",
    "unitPrice": "",
    "eventCollection" : [] (Empty while initial creation)
}]


Add list of Events
POST ("/api/save-events")
@param : List<EventDto> (@RequestBody)
[{
    "name": "",
    "eventDate": "",
    "productCollection" : []  (Empty while initial creation)
}]


Put products to event
POST("/api/put-products")
@Param: EventDto (@RequestBody)
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



Get Event details from id
GET("/event/{id}")
@Param: id (PathVariable)


Get Event details from name
GET("/event/{name}")
@Param: name (PathVariable)

