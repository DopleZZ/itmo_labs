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
        try (Connection connection = DataBaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM organizations");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Organization organization = new Organization(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        new Coordinates(
                                resultSet.getInt("coordinatesx"),
                                resultSet.getLong("coordinatesy")),
                        LocalDate.parse(resultSet.getString("creationdate")),
                        resultSet.getDouble("annualturnover"),
                        resultSet.getString("fullname"),
                        resultSet.getLong("employeescount"),
                        OrganizationType.valueOf(resultSet.getString("type")),
                        new Address(resultSet.getString("officialaddress")),
                        resultSet.getInt("user")
                );

                if (IdGenerator.getId() < resultSet.getLong("id")) {
                    IdGenerator.setId(resultSet.getLong("id"));
                }
                OrgCollection.addObj(organization);
            }
        }
    }
}
