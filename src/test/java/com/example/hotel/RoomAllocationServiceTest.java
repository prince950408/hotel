package com.example.hotel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomAllocationServiceTest {

    private final RoomAllocationService service = new RoomAllocationService();

    @Test
    public void testAllocateRoomsWith_3_3() {
        RoomAllocationService.AllocationResult result = service.allocateRooms(3, 3,
                Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));

        assertEquals(3, result.getPremiumRoomsOccupied());
        assertEquals(3, result.getEconomyRoomsOccupied());
        assertEquals(738, result.getTotalPremiumRevenue());
        assertEquals(167.99, result.getTotalEconomyRevenue());
    }

    @Test
    public void testAllocateRoomsWith_7_5() {
        RoomAllocationService.AllocationResult result = service.allocateRooms(7, 5,
                Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));

        assertEquals(6, result.getPremiumRoomsOccupied());
        assertEquals(4, result.getEconomyRoomsOccupied());
        assertEquals(1054, result.getTotalPremiumRevenue());
        assertEquals(189.99, result.getTotalEconomyRevenue());
    }

    @Test
    public void testAllocateRoomsWith_2_7() {
        RoomAllocationService.AllocationResult result = service.allocateRooms(2, 7,
                Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));

        assertEquals(2, result.getPremiumRoomsOccupied());
        assertEquals(4, result.getEconomyRoomsOccupied());
        assertEquals(583, result.getTotalPremiumRevenue());
        assertEquals(189.99, result.getTotalEconomyRevenue());
    }

    @Test
    public void testAllocateRoomsWith_7_1() {
        RoomAllocationService.AllocationResult result = service.allocateRooms(7, 1,
                Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));

        assertEquals(7, result.getPremiumRoomsOccupied());
        assertEquals(1, result.getEconomyRoomsOccupied());
        assertEquals(1099, result.getTotalPremiumRevenue());
        assertEquals(99.99, result.getTotalEconomyRevenue());
    }
}
