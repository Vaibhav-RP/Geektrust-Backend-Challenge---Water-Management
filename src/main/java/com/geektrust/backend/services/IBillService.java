package com.geektrust.backend.services;

import com.geektrust.backend.dto.BillDto;

public interface IBillService {
    public void allotWater(Integer apartmentType , String ratio);
    public void addGuest(Integer n);
    public BillDto calculateBill();
}
