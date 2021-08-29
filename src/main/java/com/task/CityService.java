package com.task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityService {


    public static void addCity(City city) throws SQLException {

        String url = "jdbc:sqlite:D:\\SQLiteTools\\homeworks.db";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String insertQuery = "INSERT INTO cities (id, name) VALUES ( '" + city.getId() + "', '" +
                city.getName() + "');";

        statement.executeUpdate(insertQuery);

        statement.close();
        connection.close();
    }

    public static List<City> getCities() throws SQLException{
        List<City> cityList = new ArrayList<>();

        String url = "jdbc:sqlite:D:\\SQLiteTools\\homeworks.db";
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM cities";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");

            cityList.add(new City(id, name));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return cityList;
    }

}
