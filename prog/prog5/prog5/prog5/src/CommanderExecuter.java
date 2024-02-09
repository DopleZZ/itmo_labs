

public class CommanderExecuter {

    Commander Commander = new Commander();

    public void execute(String command){
        switch (command) {
            case "help":
            
            Commander.help();
                
            break;

            case "info":
            Commander.info();

            break;

            case"show":
            break;

            case"add":
            break;

            case"updateId":
            break;

            case"removeById":
            break;

            case"clear":
            break;

            case"save":
            break;

            case"executeScript":
            break;

            case"exit":
            Commander.exit();
            break;

            case"head":
            break;

            case"removeLower":
            break;

            case"history":
            break;

            case"maxByType":
            break;

            case"printFieldAscendingEmployeesCount":
            break;

            case"printFieldDescendingType":
            break;
        
            default:
                System.out.println("Команда введена неверно или не существует!");
                break;
    }
}
}
