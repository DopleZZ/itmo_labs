package org.server.DataBaseWorks;

import org.server.CollectionWorks.OrgCollection;
import org.server.EnumWorks.OrganizationType;
import org.server.OrgDataWorks.Address;
import org.server.OrgDataWorks.Coordinates;
import org.server.OrgDataWorks.Organization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataParser {
    public static void baseParser() throws SQLException {
        Connection connection = DataBaseManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM organizations");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Organization organization = new Organization(
                    Long.parseLong(String.valueOf(resultSet.getInt("id"))),
                    resultSet.getString("name"),
                    new Coordinates(
                            resultSet.getInt("coordinatesx"),
                            resultSet.getLong("coordinatesy")),
                    LocalDate.of(
                            Integer.parseInt(resultSet.getString("creationdate").split("-")[0]),
                            Integer.parseInt(resultSet.getString("creationdate").split("-")[1]),
                            Integer.parseInt(resultSet.getString("creationdate").split("-")[2])),
                    resultSet.getDouble("annualturnover"),
                    resultSet.getString("fullname"),
                    resultSet.getLong("employeescount"),
                    OrganizationType.valueOf(
                            resultSet.getString("type")),
                    new Address(
                            resultSet.getString("officialaddress"))
            );
            OrgCollection.addObj(organization);
        }
    }
}
