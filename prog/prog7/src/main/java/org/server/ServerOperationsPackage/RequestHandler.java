package ServerOperationsPackage;


import Commands.Adder;
import Commands.Invoker;
import Commands.UpdaterId;
import OrgData.AddRequest;
import OrgData.BaseRequest;
import OrgData.ParentRequest;
import OrgData.UpdateRequest;

public class RequestHandler {
    
    public static void handle(Object object) throws Exception{
        
        Adder add = new Adder();
        UpdaterId up = new UpdaterId();
        try {
            

        //Class<? extends ParentRequest> request =  (Class<? extends ParentRequest>) req;
        //Class<? extends ParentRequest> request = (Class) req;
        String packageName = ((ParentRequest) object).getPackageType();

        switch (packageName) {

            case "base":
                BaseRequest baseParameterizedRequest = (BaseRequest) object;
                Invoker.invoke(baseParameterizedRequest.getCommand());
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

            default:
                break;
                }

            } catch (Exception e) {
                RecieverModule.commandResponce = "команда введена неверно";
            }

    }
}

