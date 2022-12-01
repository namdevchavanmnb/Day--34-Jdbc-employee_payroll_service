package com.bridgelabz;

import java.sql.*;

public class JdbcEmployeePayrollService {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee_payrolldata"; // table details
        String username = "root"; // MySQL credentials
        String password = "Aditya@120";
        try {
            Class.forName(
                    "com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(
                    url, username, password);
            System.out.println(
                    "Connection Established successfully");
            PreparedStatement st = con.prepareStatement("Select * from salary_details");
            PreparedStatement st2= con.prepareStatement("Select * from salary_details where StartDate Between '2018-09-21' AND '2018-09-24'");
            boolean result = st2.execute();
            if (result) {
                ResultSet rs = st2.getResultSet();
                while (rs.next()) {
                    int id
                            = rs.getInt("salary_id"); // Retrieve name from db
                    System.out.println(id); // Print result on console
                    String name
                            = rs.getString("BasicPay"); // Retrieve name from db
                    System.out.println(name); // Print result on console
                    String gender
                            = rs.getString("Deductions"); // Retrieve name from db
                    System.out.println(gender); // Print result on console
                    String city
                            = rs.getString("TaxablePay"); // Retrieve name from db
                    System.out.println(city); // Print result on console
                    String state
                            = rs.getString("Tax"); // Retrieve name from db
                    System.out.println(state); // Print result on console
                    String PhoneNumber
                            = rs.getString("NetPAy"); // Retrieve name from db
                    System.out.println(PhoneNumber); // Print result on console
                    String country
                            = rs.getString("StarDAte"); // Retrieve name from db
                    System.out.println(country); // Print result on console
                }
            }else{
                int rowcount=st2.getMaxRows();
                System.out.println(rowcount);
            }
//            } else {
//                int rowCount = st.getUpdateCount();
//                System.out.println(rowCount);
//            }

            con.close(); // close connection
            System.out.println("Connection Closed....");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}