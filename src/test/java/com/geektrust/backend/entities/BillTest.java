package com.geektrust.backend.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.constantsValue.ConstantsValue;

@DisplayName("BillTest")
public class BillTest {

    @Test
    @DisplayName("should create a bill Object")
    public void shouldCreateABillObject() {
        int apartmentType= ConstantsValue.TWO_BHK;
        String corporationIsToBoreWellRatio="1:2";
        Apartment apartment=new Apartment(apartmentType,corporationIsToBoreWellRatio);
        Bill actualBill=new Bill(apartment,1200.0);
        assertEquals(1200.0,actualBill.getTotalAmount());
    }
}