package com.geektrust.backend.entities;

import com.geektrust.backend.constantsValue.ConstantsValue;
public class Apartment{
    private Integer typeOfApartment;
    private Integer noOfAdditionalGuest;
    private Integer totalNoOfPeopleInApartment;
    private double allocatedWaterForCorporationWater;
    private double allocatedWaterForBoreWellWater;
    private Integer totalWaterConsumed;

    private Integer monthlyWaterAllocatedForPeople;

    public  Apartment(){}
    public Apartment(Integer typeOfApartment, String corporationIsToBoreWellRatio) {
        this.typeOfApartment = typeOfApartment;
        totalNoOfPeopleInApartment=0;
        noOfAdditionalGuest=0;
        totalWaterConsumed=0;
        allocatedWaterForCorporationWater=0.0;
        allocatedWaterForBoreWellWater=0.0;
        monthlyWaterAllocatedForPeople=0;
        setTotalNoOfPeopleInApartment();
        setMonthlyWaterAllocatedForPeopleAndTotalWaterConsumed();
        allotWaterToCorporateAndBoreWell(corporationIsToBoreWellRatio);
    }

    private void setTotalNoOfPeopleInApartment(){
        if(typeOfApartment.equals(ConstantsValue.TWO_BHK)){
            totalNoOfPeopleInApartment=ConstantsValue.NO_OF_PEOPLES_IN_TWO_BHK;
        }else if(typeOfApartment.equals(ConstantsValue.THREE_BHK)){
            totalNoOfPeopleInApartment=ConstantsValue.NO_OF_PEOPLES_IN_THERE_BHK;
        }
    }

    private void allotWaterToCorporateAndBoreWell(String corporationIsToBoreWellRatio){
        String [] ratioSplit=corporationIsToBoreWellRatio.split(":");
        int corporateMultiplier=Integer.parseInt(ratioSplit[0]);
        int boreWellMultiplier=Integer.parseInt(ratioSplit[1]);
        int sumOfMultiplier=corporateMultiplier+boreWellMultiplier;
        allocatedWaterForCorporationWater=(double)(totalWaterConsumed *corporateMultiplier)/sumOfMultiplier;
        allocatedWaterForBoreWellWater=(double)(totalWaterConsumed *boreWellMultiplier)/sumOfMultiplier;
    }

    private void setMonthlyWaterAllocatedForPeopleAndTotalWaterConsumed(){
        monthlyWaterAllocatedForPeople =totalNoOfPeopleInApartment*ConstantsValue.CONSUMPTION_OF_A_PERSON_PER_DAY*ConstantsValue.NO_OF_DAYS_IN_A_MONTH;
        totalWaterConsumed = monthlyWaterAllocatedForPeople;
    }

    public void addGuestToApartment(int noOfGuest){
        noOfAdditionalGuest+=noOfGuest;
        totalWaterConsumed+=noOfGuest*ConstantsValue.NO_OF_DAYS_IN_A_MONTH*ConstantsValue.CONSUMPTION_OF_A_PERSON_PER_DAY;
    }

    public Integer getNoOfAdditionalGuest() {
        return noOfAdditionalGuest;
    }

    public double getAllocatedWaterForCorporationWater() {
        return allocatedWaterForCorporationWater;
    }

    public double getAllocatedWaterForBoreWellWater() {
        return allocatedWaterForBoreWellWater;
    }

    public Integer getTotalWaterConsumed() {
        return totalWaterConsumed;
    }

    public Integer getMonthlyWaterAllocatedForTenants() {
        return monthlyWaterAllocatedForPeople;
    }

}