package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        inputData();
        outputData();
    }

    public static void inputData() throws IOException, SQLException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            System.out.print("Введите название города (или пустую строку для выхода): ");
            String str = reader.readLine();
            if (str.isEmpty()) {
                System.out.println();
                break;
            }

            CityService.addCity(new City(str));
        }
    }

    public static void outputData() throws  SQLException{
        List<City> cityList = CityService.getCities();

        for (City city : cityList) {
            System.out.println(city.toString());
        }
    }
}
