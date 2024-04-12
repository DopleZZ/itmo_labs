package ServerOperationsPackage;

import java.io.EOFException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import Commands.Adder;
import Commands.Invoker;
import Commands.UpdaterId;
import OrgData.BaseRequest;
import OrgData.ParentRequest;

public class RequestHandler {
    
    public static void handle(Object req) throws Exception{
        
        /*String command = req.getCommand();
        Object[] args = req.getArgs();

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
        }*/

        Adder add = new Adder();
        UpdaterId up = new UpdaterId();

        //Class<? extends ParentRequest> request =  (Class<? extends ParentRequest>) req;
        //Class<? extends ParentRequest> request = (Class) req;
        String packageName = ((Class<? extends ParentRequest>) req).getPackageName();

        switch (packageName) {

            case "base":
                BaseRequest parameterizedRequest = (BaseRequest) req;
                Invoker.invoke(parameterizedRequest.getCommand());
                break;
        
            default:
                break;
        }




            

            
                
                

        
        
        }
    }

