package org.ScriptWorks;

import org.NetWorks.CommandSender;
import org.Validators.OrganizationValidator;

import java.io.*;

public class ExecuteScript {

    public static void executeScript(String file, CommandSender sender) throws IOException {
        OrganizationValidator.pointer = true;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        OrganizationValidator.reader = reader;
        File file1 = new File(file);

        try {
            String line;
            line = reader.readLine();
            System.out.println("Выполнение скрипта: " + file1.getName());
            while (line != null) {
                System.out.println("Выполнение скрипта: " + file1.getName());

                sender.sendCommand(line);
                line = reader.readLine();
            }
            OrganizationValidator.pointer = false;
        } catch (Exception e) {
            System.out.println("Файл содержит ошибочную команду или рекурсию");
        }
    }
}
