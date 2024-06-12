package org.server.Commands;

import org.server.ServerOperationsPackage.RecieverModule;

public class Helper {

    
    /** 
     * вывести подсказку по командам
     * @param arg
     */
    public void execute(String arg){
        RecieverModule.commandResponce = 
        "help : вывести справку по доступным командам\n" +
                         "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.\n" +
                         "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" + //
                         "add {element} : добавить новый элемент в коллекцию\n" + //
                         "updateId {element} : обновить значение элемента коллекции, id которого равен заданному\n" + //
                         "removeById id : удалить элемент из коллекции по его id\n" + //
                         "clear : очистить коллекцию\n" + //
                         "save : сохранить коллекцию в файл\n" + //
                         "executeScript file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" + //
                         "exit : завершить программу (без сохранения в файл)\n" + //
                         "head : вывести первый элемент коллекции\n" + //
                         "removeLower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" + //
                         "history : вывести последние 7 команд (без их аргументов)\n" + //
                         "maxByType : вывести любой объект из коллекции, значение поля type которого является максимальным\n" + //
                         "printFieldAscendingEmployeesCount : вывести значения поля employeesCount всех элементов в порядке возрастания\n" + //
                         "printFieldDescendingType : вывести значения поля type всех элементов в порядке убывания\n";
    }
}



