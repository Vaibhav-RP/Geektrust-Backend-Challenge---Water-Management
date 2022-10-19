package com.geektrust.backend.commands;


import java.util.List;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IBillService;


public class AllotWaterCommand implements ICommand {
    private final IBillService billService;

    public AllotWaterCommand(IBillService billService) {
        this.billService = billService;
    }
    @Override
    public void execute(List<String> tokens) {
        try {
            billService.allotWater(Integer.valueOf(tokens.get(1)),tokens.get(2));
        } catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
