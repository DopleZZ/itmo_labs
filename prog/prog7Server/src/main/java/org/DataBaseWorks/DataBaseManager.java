package org.DataBaseWorks;

import org.EnumWorks.OrganizationType;
import org.OrgDataWorks.Address;
import org.OrgDataWorks.Coordinates;

import java.sql.*;
import java.time.LocalDate;

public class DataBaseManager {

    public static Connection connection;
    private static final String URL = ConfigManager.dataBaseURL;

    public static void ConnectToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studs", "s408301", "iWZm1YsglolA8IOX");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при подключении к базе данных");
        }
    }

    public static void add(Object[] args){
       String name = (String) args[0];
       Coordinates coordinates = new Coordinates(Integer.parseInt(((String) args[1]).split(";")[0]),  Long.parseLong(((String) args[1]).split(";")[1]));
       Double annualTurnover = Double.parseDouble( args[2].toString());
       String fullName = ((String) args[3]);
       Long employeesCount = Long.parseLong( args[4].toString());
       OrganizationType type = OrganizationType.valueOf( args[5].toString());
       Address officialAddress = new Address((String) args[6]);
       int  UserId = Integer.parseInt( args[7].toString());

         try {
              PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO organizations (\"name\",\"coordinatesx\",\"coordinatesy\",\"creationdate\",\"annualturnover\",\"fullname\",\"Employeescount\",\"type\",\"officialaddress\",\"user\") VALUES (?,?,?,?,?,?,?,?,?,?)");
              preparedStatement.setString(1, name);
              preparedStatement.setString(2, coordinates.getX());
              preparedStatement.setString(3, coordinates.getY());
              preparedStatement.setString(4, LocalDate.now().toString());
              preparedStatement.setString(5, String.valueOf(annualTurnover));
              preparedStatement.setString(6, fullName);
              preparedStatement.setString(7, String.valueOf(employeesCount));
              preparedStatement.setString(8, type.toString());
              preparedStatement.setString(9, officialAddress.getStreet());
              preparedStatement.setString(10, String.valueOf(UserId));
              preparedStatement.executeUpdate();
         } catch (SQLException e) {
              e.printStackTrace();
              System.out.println("Возникла ошибка при добавлении объекта в базу данных");
         }
    }

    public static void update(Object[] args){
        String name = (String) args[0];
        Coordinates coordinates = new Coordinates(Integer.parseInt(((String) args[1]).split(";")[0]),  Long.parseLong(((String) args[1]).split(";")[1]));
        Double annualTurnover = Double.parseDouble( args[2].toString());
        String fullName = ((String) args[3]);
        Long employeesCount = Long.parseLong( args[4].toString());
        OrganizationType type = OrganizationType.valueOf( args[5].toString());
        Address officialAddress = new Address((String) args[6]);

        String idToUpdate = (String) args[7];

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE organizations SET \"name\" = ?, \"coordinatesx\" = ?, \"coordinatesy\" = ?,  \"annualturnover\" = ?, \"fullname\" = ?, \"Employeescount\" = ?, \"type\" = ?, \"officialaddress\" = ? WHERE id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, coordinates.getX());
            preparedStatement.setString(3, coordinates.getY());
            preparedStatement.setString(4, String.valueOf(annualTurnover));
            preparedStatement.setString(5, fullName);
            preparedStatement.setString(6, String.valueOf(employeesCount));
            preparedStatement.setString(7, type.toString());
            preparedStatement.setString(8, officialAddress.getStreet());
            preparedStatement.setInt(9, Integer.parseInt(idToUpdate));
            preparedStatement.executeUpdate();
            System.out.println("Объект успешно обновлен");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при обновлении объекта в базе данных");
        }
    }

    public static boolean checkOwner(int idUser, int idToCheck){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM organizations WHERE id = ?");
            preparedStatement.setInt(1, idToCheck);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("user") == idUser;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при проверке владельца объекта");
            return false;
        }

    }

    public static void addUser(String login, String pass){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (\"userlog\",\"userpass\") VALUES (?,?)");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, EncryptManager.encryptThisString(pass));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при добавлении пользователя в базу данных");
        }
    }

    public static void delete(int idToDelete){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM organizations WHERE \"id\" = ?");
            preparedStatement.setInt(1, idToDelete);
            preparedStatement.executeUpdate();
            System.out.println("Объект успешно удален");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при удалении объекта из базы данных");
        }
    }

    public static String removeLower(int idToRemove, int uid){
        String ans = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM organizations WHERE \"id\" < ? AND \"user\" = ?");
            preparedStatement.setInt(1, idToRemove);
            preparedStatement.setString(2, String.valueOf(uid));
            preparedStatement.executeUpdate();
            System.out.println("Объекты успешно удалены");
            ans = "Объекты успешно удалены";
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при удалении объектов из базы данных");
            ans = "Возникла ошибка при удалении объектов из базы данных";
        }
        return ans;
    }

    public static Connection getConnection() {
        return connection;
    }
}
