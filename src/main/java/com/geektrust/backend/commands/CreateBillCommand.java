package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IBillService;

public class CreateBillCommand implements ICommand {
    private final IBillService billService;

    public CreateBillCommand(IBillService billService) {
        this.billService = billService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            System.out.println(billService.calculateBill());
        } catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
