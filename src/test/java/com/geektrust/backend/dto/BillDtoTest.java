package com.geektrust.backend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BillDtoTest")
public class BillDtoTest {
    @Test
    @DisplayName("Should create a BillDto Object")
    public void shouldCreateABillDtoObject() {
        BillDto generatedBillDto = new BillDto(4500 ,13625);
        String expectedString="4500 13625";
        String acutalString=generatedBillDto.toString();
        assertEquals(expectedString,acutalString);
    }
}