package org.DataBaseWorks;

import org.CollectionWorks.OrgCollection;
import org.EnumWorks.OrganizationType;
import org.OrgDataWorks.Address;
import org.OrgDataWorks.Coordinates;
import org.OrgDataWorks.Organization;
import org.OrgDataWorks.IdGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataParser {
    public static void baseParse() throws SQLException {
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
                    resultSet.getLong("Employeescount"),
                    OrganizationType.valueOf(
                            resultSet.getString("type")),
                    new Address(
                            resultSet.getString("officialaddress"))
                    , resultSet.getInt("user")
            );
            if (IdGenerator.id < Long.parseLong(String.valueOf(resultSet.getInt("id"))))
                IdGenerator.id = Long.parseLong(String.valueOf(resultSet.getInt("id")));
            OrgCollection.addObj(organization);

        }
    }
}
