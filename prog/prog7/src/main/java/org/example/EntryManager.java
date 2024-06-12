package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryManager {

    Connection con;

    public EntryManager(Connection con){
        this.con = con;
    }

    public Boolean checkIfExist(String user_login) throws SQLException {
        PreparedStatement checkStatement = con.prepareStatement("SELECT count(*) FROM users WHERE (userlog = ?)");
        checkStatement.setString(1, user_login);
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("count") != 0;
    }

    public void register() throws IOException, SQLException {
        boolean ready = false;
        String userLogin;
        String userPassword;
        while (!ready){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Придумайте логин");
            userLogin = reader.readLine();
            if (!userLogin.isEmpty()){
                if (!checkIfExist(userLogin)){
                    System.out.println("Придумайте пароль");
                    userPassword = reader.readLine();
                    if (!userPassword.isEmpty()){
                        EncryptManager.encryptThisString(userPassword);
                        PreparedStatement insertStatement = con.prepareStatement("INSERT INTO users (userpass, userlog) VALUES (?, ?)");
                        insertStatement.setString(1, EncryptManager.encryptThisString(userPassword));
                        insertStatement.setString(2, userLogin);
                        insertStatement.executeUpdate();
                        ready = true;
                    }
                } else {
                    System.out.println("Такой логин уже существует");
                }
            } else {
                continue;
            }
        }
    }

    public boolean validUser(String login, String pass) throws SQLException {
        PreparedStatement checkStatement = con.prepareStatement("SELECT count(*) FROM users WHERE (userlog = ?) AND (userpass = ?)");
        checkStatement.setString(1,login);
        checkStatement.setString(2,EncryptManager.encryptThisString(pass));
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("count")!=0;
    }
}
