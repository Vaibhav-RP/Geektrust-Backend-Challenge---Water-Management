package com.geektrust.backend.dto;

public class BillDto {
    private Integer totalWaterConsumed;
    private Integer totalCost;

    public BillDto(Integer totalWaterConsumed, Integer totalCost) {
        this.totalWaterConsumed = totalWaterConsumed;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return totalWaterConsumed +" "+ totalCost;
    }

}