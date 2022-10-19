package com.geektrust.backend.services;

import com.geektrust.backend.constantsValue.ConstantsValue;
import com.geektrust.backend.dto.BillDto;
import com.geektrust.backend.entities.Apartment;
import com.geektrust.backend.entities.Bill;

public class BillService implements IBillService {

    private Apartment apartment;

    public BillService() {
        this.apartment = new Apartment();
    }

    @Override
    public void allotWater(Integer typeOfApartment, String corporationIsToBoreWellRatio) {
        apartment=new Apartment(typeOfApartment,corporationIsToBoreWellRatio);
    }

    @Override
    public void addGuest(Integer noOfGuests) {
        apartment.addGuestToApartment(noOfGuests);
    }

    @Override
    public BillDto calculateBill() {
        double totalAmount=calculateBillForCorporateWater()+calculateBillForBoreWellWater()+calculateBillForTankerWater();
        Bill bill = new Bill(apartment,totalAmount);
        return new BillDto(apartment.getTotalWaterConsumed(),(int) Math.ceil(totalAmount));
    }

    private double calculateBillForCorporateWater(){
        return apartment.getAllocatedWaterForCorporationWater()*ConstantsValue.CORPORATION_WATER_RATE;
    }

    private double calculateBillForBoreWellWater(){
        return apartment.getAllocatedWaterForBoreWellWater()*ConstantsValue.BOREWELL_WATER_RATE;
    }

    private double calculateBillForTankerWater(){
        int totalWaterForAdditionalGuests=apartment.getTotalWaterConsumed()-apartment.getMonthlyWaterAllocatedForTenants();
        double billForTankerWater=0.0;

        if(totalWaterForAdditionalGuests<=ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE){
            billForTankerWater+=totalWaterForAdditionalGuests*ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_RATE;
            
        }else if(totalWaterForAdditionalGuests > ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE
                && totalWaterForAdditionalGuests<=ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE){
            billForTankerWater+=((ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE*ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_RATE)+
                    (totalWaterForAdditionalGuests-ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE)*ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_RATE);
        }else if(totalWaterForAdditionalGuests > ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE &&totalWaterForAdditionalGuests<=ConstantsValue.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE){
            billForTankerWater+=((ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE*ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_RATE)+(ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_Difference*ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_RATE)+
                    (totalWaterForAdditionalGuests-ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE)*ConstantsValue.TANKER_WATER_SLAB_1501_TO_3000L_RATE);
        }else{
            billForTankerWater+=((ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE*ConstantsValue.TANKER_WATER_SLAB_0_TO_500L_RATE)+
                    (ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_Difference*ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_RATE)+
                    (ConstantsValue.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE*ConstantsValue.TANKER_WATER_SLAB_1501_TO_3000L_RATE)+
                    (totalWaterForAdditionalGuests-ConstantsValue.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE)*ConstantsValue.TANKER_WATER_SLAB_3001_PLUS_RATE);
        }
        return billForTankerWater;
    }

   

}