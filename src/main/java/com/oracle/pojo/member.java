package com.oracle.pojo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.*;

public class member{
    public static void main(String[] args) {
        try {
            //class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/class?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","wwk426096");
            String SQL="select * from classtable";
            PreparedStatement statement=connection.prepareStatement(SQL);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}




