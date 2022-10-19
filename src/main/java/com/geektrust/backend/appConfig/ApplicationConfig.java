package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.AddGuestCommand;
import com.geektrust.backend.services.BillService;
import com.geektrust.backend.services.IBillService;
import com.geektrust.backend.commands.AllotWaterCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.CreateBillCommand;

public class ApplicationConfig {

    private final IBillService billService = new BillService(); 

    private final AllotWaterCommand allotWaterCommand = new AllotWaterCommand(billService);
    private final AddGuestCommand addGuestCommand = new AddGuestCommand(billService);
    private final CreateBillCommand createBillCommand = new CreateBillCommand(billService);
   
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("ALLOT_WATER", allotWaterCommand);
        commandInvoker.register("ADD_GUESTS", addGuestCommand);
        commandInvoker.register("BILL", createBillCommand);
       
        return commandInvoker;
    }

}
