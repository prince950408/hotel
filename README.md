# Hotel

### Build the project
```sh
./mvnw clean install
```

### Run the project
```sh
./mvnw spring-boot:run
```

### Tests
```sh
./mvnw test
```

Example Request
```
curl -X POST "http://localhost:8080/api/rooms/allocate?premiumRooms=3&economyRooms=3" -H "Content-Type: application/json" -d "[23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]"
```

