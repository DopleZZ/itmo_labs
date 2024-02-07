package Interfaces;

import Exceptions.WrongArgumentException;

public interface CommandInterface {
    
    public void help(String asd) throws WrongArgumentException;

    public void info();

    public void show();

    public void add();

    public void updateId();

    public void removeById();

    public void clear();

    public void save();

    public void executeScript(String fileName);

    public void exit();

    public void head();

    public void removeLower();

    public void history();

    public void maxByType();

    public void printFieldAscendingEmployeesCount();

    public void printFieldDescendingType();
}
