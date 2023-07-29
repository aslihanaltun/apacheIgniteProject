package org.example;

import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {

        String jdbcUrl = "jdbc:ignite:thin://127.0.0.1:10800/";

        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, user, password)) {
            String query = "SELECT SUBSC_ID, SUBSC_NAME, SUBSC_SURNAME, MSISDN, TARIFF_ID, START_DATE FROM SUBSCRIBER";
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        long subscId = rs.getLong("SUBSC_ID");
                        String subscName = rs.getString("SUBSC_NAME");
                        String subscSurname = rs.getString("SUBSC_SURNAME");
                        String msisdn = rs.getString("MSISDN");
                        long tariffId = rs.getLong("TARIFF_ID");
                        Date startDate = rs.getDate("START_DATE");

                        System.out.println("SUBSC_ID: " + subscId +
                                ", SUBSC_NAME: " + subscName +
                                ", SUBSC_SURNAME: " + subscSurname +
                                ", MSISDN: " + msisdn +
                                ", TARIFF_ID: " + tariffId +
                                ", START_DATE: " + startDate);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
