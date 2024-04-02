package ServerOperationsPackage;

import java.io.EOFException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import Commands.Add;
import Commands.Invoker;
import Commands.UpdateId;
import OrgData.ClientRequest;

public class RequestHandler {
    
    public static void handle(ClientRequest req) throws Exception{
        
        String command = req.getCommand();
        Object[] args = req.getArgs();
        Add add = new Add();
        UpdateId up = new UpdateId();
        try {
            if (args.length == 7){
                if (command.equals("add")){
                    add.execute(args);
                }
            } else if (command.contains("updateById")){
                    up.execute(args);
            } else {
         
            Invoker.invoke(command);}
        } catch (Exception e) {
            RecieverModule.commandResponce="Команда введена неверно, или не существует";
        }

            

            
                
                

        
        
        }
    }

