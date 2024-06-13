package org.DataBaseWorks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    public static int port;
    static String dataBaseURL;
    static String user;
    static String passWord;
    public static void getConfig() throws IOException {
        Path fileName = Paths.get(System.getenv("Var1"));
        String[] content = Files.readString(fileName).split("\n");
        port = Integer.parseInt(content[0].split(": ")[1]);
        dataBaseURL = content[1].split(": ")[1];
        user = content[2].split(": ")[1];
        passWord = content[3].split(": ")[1];

    }
}
