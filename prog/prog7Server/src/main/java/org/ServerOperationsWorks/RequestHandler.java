package org.ServerOperationsWorks;


import com.google.gson.Gson;
import org.CommandWorks.*;
import org.OrgDataWorks.*;

import java.nio.channels.SocketChannel;

public class RequestHandler {


    public RequestHandler() {

    }


    public ClientResponce execute(ParentRequest request) {
        System.out.println("RequestHandler.run");
        AddCommand add = new AddCommand();
        UpdateIdCommand up = new UpdateIdCommand();
        String ans = null;
        try {

            String packageName = ((ParentRequest) request).getPackageType();
            System.out.println(packageName);

            switch (packageName) {

                case "base":
                    BaseRequest baseParameterizedRequest = (BaseRequest) request;
                    ans = InvokeCommand.invoke(baseParameterizedRequest.getCommand(), baseParameterizedRequest.getUserId());
                    break;

                case "update":
                    UpdateRequest updateParameterizedRequest = (UpdateRequest) request;
                    Object[] argsToUpdate = {
                            updateParameterizedRequest.getName(),
                            updateParameterizedRequest.getCoordinates(),
                            updateParameterizedRequest.getAnnualTurnover(),
                            updateParameterizedRequest.getFullName(),
                            updateParameterizedRequest.getEmployeesCount(),
                            updateParameterizedRequest.getType(),
                            updateParameterizedRequest.getAdress(),
                            updateParameterizedRequest.getId(),
                            updateParameterizedRequest.getUserId()
                    };
                    ans = up.execute(argsToUpdate);
                    break;

                case "add":
                    AddRequest addParameterizedRequest = (AddRequest) request;
                    Object[] argsToAdd = {
                            addParameterizedRequest.getName(),
                            addParameterizedRequest.getCoordinates(),
                            addParameterizedRequest.getAnnualTurnover(),
                            addParameterizedRequest.getFullName(),
                            addParameterizedRequest.getEmployeesCount(),
                            addParameterizedRequest.getType(),
                            addParameterizedRequest.getAdress(),
                            addParameterizedRequest.getUserId()
                    };
                    ans = add.execute(argsToAdd);
                    break;

                case "entry":
                    //System.out.println("entry");
                    EntryRequest entryParameterizedRequest = (EntryRequest) request;
                    ans = EntryCommand.execute(entryParameterizedRequest.getLogin(), entryParameterizedRequest.getPassword());
                    break;

                case "register":
                    RegisterRequest registerParameterizedRequest = (RegisterRequest) request;
                    ans = RegisterCommand.execute(registerParameterizedRequest.getLogin(), registerParameterizedRequest.getPassword());
                    break;

                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
            ans = "команда введена неверно";
        }

        return new ClientResponce(ans);
    }
}

