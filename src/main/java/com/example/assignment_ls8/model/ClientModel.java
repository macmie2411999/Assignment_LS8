package com.example.assignment_ls8.model;

import com.example.assignment_ls8.connection.MySQLConnection;
import com.example.assignment_ls8.pojo.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientModel {
    public boolean insertClient(Client data){
        Connection connection = MySQLConnection.getConnection();
        String sql = "insert into Client(ID_Client, Email_Client, Password_Client, FullName_Client) values (?, ?, ?, ?)";
        boolean isSuccess = false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, data.getID());
            statement.setString(2, data.getEmail());
            statement.setString(3, data.getPassword());
            statement.setString(3, data.getFullName());
            int result = statement.executeUpdate();
            if(result > 0){
                isSuccess = true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public Client getClient(String email, String password){
        Client client = null;
        Connection connection = MySQLConnection.getConnection();
        String sql = "select * from Client where Email_Client = ? and Password_Client = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                client = new Client();
                client.setFullName(resultSet.getString("FullName_Client"));
                client.setEmail(resultSet.getString("Email_Client"));
                client.setPassword(resultSet.getString("Password_Client"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  client;
    }
}
