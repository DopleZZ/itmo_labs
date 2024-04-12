package ServerOperationsPackage;


import Commands.Adder;
import Commands.Invoker;
import Commands.UpdaterId;
import OrgData.BaseRequest;
import OrgData.ParentRequest;

public class RequestHandler {
    
    public static void handle(Object object) throws Exception{
        
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
        String packageName = ((ParentRequest) object).getPackageType();

        switch (packageName) {

            case "base":
                BaseRequest parameterizedRequest = (BaseRequest) object;
                Invoker.invoke(parameterizedRequest.getCommand());
                break;
        
            default:
                break;
        }




            

            
                
                

        
        
        }
    }

