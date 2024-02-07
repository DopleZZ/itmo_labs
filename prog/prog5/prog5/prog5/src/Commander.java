import java.io.BufferedReader;
import java.io.FileReader;

import Exceptions.WrongArgumentException;
import Interfaces.*;

public class Commander implements CommandInterface{
    public Commander(){}

    @Override
    public void help(String asd) throws WrongArgumentException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (Exception e) {
            throw new WrongArgumentException("все, пиздец");
        }
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
    public void exit(){}

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
