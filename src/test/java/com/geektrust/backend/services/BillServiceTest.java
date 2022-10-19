package com.geektrust.backend.services;

import com.geektrust.backend.constantsValue.ConstantsValue;
import com.geektrust.backend.dto.BillDto;
import com.geektrust.backend.entities.Apartment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@DisplayName("BillServiceTest")
@ExtendWith(MockitoExtension.class)
public class BillServiceTest {

    @Mock
    private BillService apartmentBillServiceMock;

    @Test
    @DisplayName("should Generate Bill For Apartment")
    public void shouldGenerateBillForApartments(){
        //Arrange
        String corporationIsToBoreWellRatio="1:2";
        Apartment expectedApartment = new Apartment(ConstantsValue.TWO_BHK, corporationIsToBoreWellRatio);
        BillDto generatedBillDtoExpected=new BillDto(900,1200);
        when(apartmentBillServiceMock.calculateBill()).thenReturn(generatedBillDtoExpected);

        //Act
        BillDto generatedBillDtoActual = apartmentBillServiceMock.calculateBill();

        //Assert
        Assertions.assertEquals(generatedBillDtoExpected,generatedBillDtoActual);
        verify(apartmentBillServiceMock,times(1)).calculateBill();
    }



}