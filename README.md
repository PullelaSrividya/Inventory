# Inventory
Search Inventory based on type

## Used Tools
  
  1) H2 - inmemory database
  2) spring boot
  3) spring MVC
  4) Maven
  
## Schema
  
  ```
  CREATE TABLE vehicles_inventory (
    ID Integer PRIMARY KEY AUTO_INCREMENT,
    vehicle_type varchar(50) NOT NULL,
    color varchar(50), 
    make varchar(50)
  );
  ```
  
## These are the folloing CRUD operations designed. used GET for all operations for simplicity

  1) *to list all the vehicles.*
    
    ```http://localhost:8080/inventory/vehicles```
    
  2) *to search based on type. vehicle_type is a request param.*
  
    ```http://localhost:8080/inventory/vehicles/type/{vehicle_type}
    
    example:
    
    http://localhost:8080/inventory/vehicles/type/boat```
  
  3) *to add vehicle to inventory. vehicle_type, make. color are request params.*
    
    ```http://localhost:8080/inventory/vehicle/{make}/{color}/{vehicle_type}/add
    
    example:
    
    http://localhost:8080/inventory/vehicle/chevy/orange/plane/add```
    
  4) *to update vehicle in inventory based on id. vehicle_type, make. color, id are request params.*
    
    ```http://localhost:8080/inventory/vehicle/{id}/{make}/{color}/{vehicle_type}/update
    
    example:
    
    http://localhost:8080/inventory/vehicle/141/chevy/orange/plane/update```
 
