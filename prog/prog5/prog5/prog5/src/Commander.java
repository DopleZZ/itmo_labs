import Exceptions.WrongArgumentException;
import Interfaces.CommandInterface;


public class Commander implements CommandInterface{
    public Commander(){}

    private boolean exit = true;

    public void negr(String asd) throws WrongArgumentException{
        if (asd.equals("help")) {
            throw new WrongArgumentException();
            
        }
    }

    @Override
    public void help(){
        System.out.print("help : вывести справку по доступным командам\n" +
                         "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.\n" +
                         "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" + //
                         "add {element} : добавить новый элемент в коллекцию\n" + //
                         "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" + //
                         "remove_by_id id : удалить элемент из коллекции по его id\n" + //
                         "clear : очистить коллекцию\n" + //
                         "save : сохранить коллекцию в файл\n" + //
                         "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" + //
                         "exit : завершить программу (без сохранения в файл)\n" + //
                         "head : вывести первый элемент коллекции\n" + //
                         "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" + //
                         "history : вывести последние 7 команд (без их аргументов)\n" + //
                         "max_by_type : вывести любой объект из коллекции, значение поля type которого является максимальным\n" + //
                         "print_field_ascending_employees_count : вывести значения поля employeesCount всех элементов в порядке возрастания\n" + //
                         "print_field_descending_type : вывести значения поля type всех элементов в порядке убывания\n");
    }

    @Override
    public void info(){}

    @Override
    public void show(){}

    @Override
    public void add(){}

    @Override
    public void updateId(){}

    @Override
    public void removeById(){}

    @Override
    public void clear(){}

    @Override
    public void save(){}

    @Override
    public void executeScript(String fileName){}

    @Override
    public void exit(){
        System.exit(0);
    }

    @Override
    public void head(){}

    @Override
    public void removeLower(){}

    @Override
    public void history(){}

    @Override
    public void maxByType(){}

    @Override
    public void printFieldAscendingEmployeesCount(){}

    @Override
    public void printFieldDescendingType(){}




}
