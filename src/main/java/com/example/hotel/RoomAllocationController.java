package com.example.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomAllocationController {

    @Autowired
    private RoomAllocationService roomAllocationService;

    @PostMapping("/allocate")
    public RoomAllocationService.AllocationResult allocateRooms(
            @RequestParam int premiumRooms,
            @RequestParam int economyRooms,
            @RequestBody List<Double> offers) {
        return roomAllocationService.allocateRooms(premiumRooms, economyRooms, offers);
    }
}
