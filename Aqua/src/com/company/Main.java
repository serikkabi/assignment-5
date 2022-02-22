package com.company;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    static final String QUERY1 = "SELECT * FROM public.\"Stones\"";

    public static void main(String[] args) throws SQLException {
        // write your code here
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "715132004")) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(QUERY1);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        while (rs.next()) {
//            //Display values
//            System.out.print("Fish " + rs.getString("Name"));
//            System.out.print(" is cost " + rs.getInt("Prices")+"tg\n");
//        }

        boolean work = true;
        while (work) {

            int i;
            System.out.print(" 1.Stones\n");

            System.out.print("Choose number: ");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            int io;
            switch (i) {
                case 1:
                    System.out.print(" 1.Diamond\n 2.Emerald\n 3.Jade\n 4.Sapphire\n 5.Amber\n 6.Ruby\n 7.Garnet\n 8.Topaz\n 9.Alexandrite\n 10.Agate\n 11.Demantoid\n 0.Exit\n");

                    System.out.print("Choose number: ");
                    io = scanner.nextInt();
                    rs.absolute(io);
                    System.out.println("Stone " + rs.getString(1) + " is cost " + rs.getString(2) + "tg " + "per " + rs.getString(3) + " karat.");
break;
                case 0:
                    work=false;
            }

        }

    }
    }

