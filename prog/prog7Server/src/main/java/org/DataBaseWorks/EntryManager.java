package org.DataBaseWorks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntryManager {
    //Connection con;

    public static Connection con = DataBaseManager.getConnection();

    //public EntryManager(Connection con){
        //this.con = con;
    //}

    public Boolean checkIfExist(String user_login) throws SQLException {
        PreparedStatement checkStatement = con.prepareStatement("SELECT count(*) FROM users WHERE (userlog = ?)");
        checkStatement.setString(1, user_login);
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("count") != 0;
    }

    public boolean authenticate(String login, String pass) throws SQLException {
        PreparedStatement checkStatement = con.prepareStatement("SELECT count(*) FROM users WHERE (userlog = ?) AND (userpass = ?)");
        checkStatement.setString(1,login);
        checkStatement.setString(2,EncryptManager.encryptThisString(pass));
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("count")!=0;
    }

    public String getUserId(String login) throws SQLException {
        PreparedStatement checkStatement = con.prepareStatement("SELECT userid FROM users WHERE (userlog = ?)");
        checkStatement.setString(1,login);
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        return String.valueOf(resultSet.getInt("userid"));
    }
}