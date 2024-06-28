package com.example.hotel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAllocationService {

    public AllocationResult allocateRooms(int premiumRooms, int economyRooms, List<Double> offers) {
        List<Double> sortedOffers = offers.stream()
                .sorted((a, b) -> Double.compare(b, a))
                .toList();

        int premiumCount = 0;
        int economyCount = 0;
        double totalPremiumRevenue = 0.0;
        double totalEconomyRevenue = 0.0;

        for (Double offer : sortedOffers) {
            if (offer >= 100) {
                if (premiumCount < premiumRooms) {
                    premiumCount++;
                    totalPremiumRevenue += offer;
                }
            } else {
                if (economyCount < economyRooms) {
                    economyCount++;
                    totalEconomyRevenue += offer;
                } else if (premiumCount < premiumRooms) {
                    premiumCount++;
                    totalPremiumRevenue += offer;
                }
            }
        }

        return new AllocationResult(premiumCount, economyCount, totalPremiumRevenue, totalEconomyRevenue);
    }

    public static class AllocationResult {
        private int premiumRoomsOccupied;
        private int economyRoomsOccupied;
        private double totalPremiumRevenue;
        private double totalEconomyRevenue;

        public AllocationResult(int premiumRoomsOccupied, int economyRoomsOccupied, double totalPremiumRevenue, double totalEconomyRevenue) {
            this.premiumRoomsOccupied = premiumRoomsOccupied;
            this.economyRoomsOccupied = economyRoomsOccupied;
            this.totalPremiumRevenue = totalPremiumRevenue;
            this.totalEconomyRevenue = totalEconomyRevenue;
        }

        public int getPremiumRoomsOccupied() {
            return premiumRoomsOccupied;
        }

        public int getEconomyRoomsOccupied() {
            return economyRoomsOccupied;
        }

        public double getTotalPremiumRevenue() {
            return totalPremiumRevenue;
        }

        public double getTotalEconomyRevenue() {
            return totalEconomyRevenue;
        }
    }
}
