package org.ServerOperationsWorks;


import org.CommandWorks.AddCommand;
import org.CommandWorks.EntryCommand;
import org.CommandWorks.InvokeCommand;
import org.CommandWorks.UpdateIdCommand;
import org.OrgDataWorks.*;

import java.nio.channels.SocketChannel;

public class RequestHandler extends Thread {

    private final Object request;
    private final Server server;
    private final SocketChannel socketChannel;

    public RequestHandler(Object request, Server server, SocketChannel socketChannel) {
        System.out.println("RequestHandler123");
        this.request = request;
        this.server = server;
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {

        System.out.println("RequestHandler");
        AddCommand add = new AddCommand();
        UpdateIdCommand up = new UpdateIdCommand();
        try {
        //Class<? extends ParentRequest> request =  (Class<? extends ParentRequest>) req;
        //Class<? extends ParentRequest> request = (Class) req;
        String packageName = ((ParentRequest) request).getPackageType();
            System.out.println(packageName);
        switch (packageName) {

            case "base":
                BaseRequest baseParameterizedRequest = (BaseRequest) request;
                RequestAnswerer ans = new RequestAnswerer(InvokeCommand.invoke(baseParameterizedRequest.getCommand()), server, socketChannel);
                ans.run();
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
                    updateParameterizedRequest.getId()
                };
                up.execute(argsToUpdate);
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
                };
                add.execute(argsToAdd);
                break;

            case "entry":
                System.out.println("entry");
                EntryRequest entryParameterizedRequest = (EntryRequest) request;
                RequestAnswerer entryAns = new RequestAnswerer(EntryCommand.execute(entryParameterizedRequest.getLogin() + " " + entryParameterizedRequest.getPassword()), server, socketChannel);
                System.out.println("entryAns");
                entryAns.run();


            default:
                break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                //RecieverModule.commandResponce = "команда введена неверно";
            }

    }
}

