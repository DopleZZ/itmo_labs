package org.ServerOperationsWorks;


import org.CommandWorks.AddCommand;
import org.CommandWorks.EntryCommand;
import org.CommandWorks.InvokeCommand;
import org.CommandWorks.UpdateIdCommand;
import org.OrgDataWorks.*;
import org.OrgDataWorks.*;

public class RequestHandler {
    
    public static void handle(Object object) throws Exception{

        System.out.println("RequestHandler");
        AddCommand add = new AddCommand();
        UpdateIdCommand up = new UpdateIdCommand();
        try {
            

        //Class<? extends ParentRequest> request =  (Class<? extends ParentRequest>) req;
        //Class<? extends ParentRequest> request = (Class) req;
        String packageName = ((ParentRequest) object).getPackageType();

        switch (packageName) {

            case "base":
                BaseRequest baseParameterizedRequest = (BaseRequest) object;
                InvokeCommand.invoke(baseParameterizedRequest.getCommand());
                break;

            case "update":
                UpdateRequest updateParameterizedRequest = (UpdateRequest) object;
                Object[] argsToUpdate = {
                    updateParameterizedRequest.getName(),
                    updateParameterizedRequest.getCoordinates(),
                    updateParameterizedRequest.getAnnualTurnover(),
                    updateParameterizedRequest.getFullName(),
                    updateParameterizedRequest.getEmployeesCount(),
                    updateParameterizedRequest.getType(),
                    updateParameterizedRequest.getAdress(),
                    updateParameterizedRequest.getId()
                };
                up.execute(argsToUpdate);
                break;
            
            case "add":
                AddRequest addParameterizedRequest = (AddRequest) object;
                Object[] argsToAdd = {
                    addParameterizedRequest.getName(),
                    addParameterizedRequest.getCoordinates(),
                    addParameterizedRequest.getAnnualTurnover(),
                    addParameterizedRequest.getFullName(),
                    addParameterizedRequest.getEmployeesCount(),
                    addParameterizedRequest.getType(),
                    addParameterizedRequest.getAdress(),
                };
                add.execute(argsToAdd);
                break;

            case "entry":
                EntryRequest entryParameterizedRequest = (EntryRequest) object;
                EntryCommand.execute(entryParameterizedRequest.getLogin() + " " + entryParameterizedRequest.getPassword());


            default:
                break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                RecieverModule.commandResponce = "команда введена неверно";
            }

    }
}

