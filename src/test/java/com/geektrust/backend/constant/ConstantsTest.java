package com.geektrust.backend.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.geektrust.backend.constantsValue.ConstantsValue;

@DisplayName("ConstantsTest")
public class ConstantsTest {

    @Test
    @DisplayName("Testing Constants Value")
    public void testCheckingConstantsValue(){
        assertEquals(1000,ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_Difference );
        assertNotEquals(2,ConstantsValue.NO_OF_PEOPLES_IN_TWO_BHK);
        assertEquals(3, ConstantsValue.NO_OF_PEOPLES_IN_TWO_BHK);
        assertNotEquals(3,ConstantsValue.NO_OF_PEOPLES_IN_THERE_BHK );
        assertEquals(10,ConstantsValue.CONSUMPTION_OF_A_PERSON_PER_DAY );
        assertNotEquals(25,ConstantsValue.NO_OF_DAYS_IN_A_MONTH);
        assertEquals(1500,ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE);
       
    }
}