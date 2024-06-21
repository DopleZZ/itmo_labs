package org.ServerOperationsWorks;

import org.CommandWorks.*;
import org.OrgDataWorks.*;

public class RequestHandler {

    public static ClientResponce execute(ParentRequest request) {
        System.out.println("начата обработка запроса"); // TODO log
        AddCommand add = new AddCommand();
        UpdateIdCommand up = new UpdateIdCommand();
        String ans = null;
        try {

            PackageType packageName = ((ParentRequest) request).getPackageType();

            switch (packageName) {

                case BASE:
                    BaseRequest baseParameterizedRequest = (BaseRequest) request;
                    ans = InvokeCommand.invoke(baseParameterizedRequest.getCommand(),
                            baseParameterizedRequest.getUserId());
                    break;

                case UPDATE:
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

                case ADD:
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

                case ENTRY:
                    // System.out.println("entry");
                    EntryRequest entryParameterizedRequest = (EntryRequest) request;
                    ans = EntryCommand.execute(entryParameterizedRequest.getLogin(),
                            entryParameterizedRequest.getPassword());
                    break;

                case REGISTER:
                    RegisterRequest registerParameterizedRequest = (RegisterRequest) request;
                    ans = RegisterCommand.execute(registerParameterizedRequest.getLogin(),
                            registerParameterizedRequest.getPassword());
                    break;

                default:
                    break;
            }

        } catch (Exception e) {
            ans = "команда введена неверно";
        }

        return new ClientResponce(ans);
    }
}
