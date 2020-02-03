package application.dao;

import application.dbconnection.DbConnection;
import application.model.Information;

import javafx.collections.ObservableList;

import java.sql.*;

public class InformationDAOImpl implements InformationDAO {

    private DbConnection dbConnection = new DbConnection();
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private Information in;

    //Entity
    @Override
    public void addEntity(String organization, String post, String lastName, String firstName,
                          String middleName, String town, String date, String contact, String description,
                          String postIndex) {
        try {
            String query = "INSERT INTO contact.fc_face (ID_TYPE, POST, FAMILY, NAME1, NAME2, NAME)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            Connection connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, post);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, firstName);
            preparedStatement.setString(5, middleName);
            preparedStatement.setString(6, organization);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        try {
            String query = "INSERT INTO contact.fc_contact (ID_FC, ID_TYPE, TOWN, CONTACT, " +
                    "DESCRIPTION, DATE_B, POST_INDEX) VALUES(?, ?, ?, ?, ?, ?, ?)";
            Connection connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 2);
            preparedStatement.setString(3, town);
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, description);
            preparedStatement.setString(6, date);
            preparedStatement.setString(7, postIndex);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        try {
            String query = "INSERT INTO contact.fc_lstype_contact (NAME) VALUES(?)";
            Connection connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    //Individual
    @Override
    public void addIndividual(String lastName, String firstName, String middleName, String town,
                              String date, String contact, String description, String postIndex) {
        try {
            String query = "INSERT INTO contact.fc_face (ID_TYPE, FAMILY, NAME1, NAME2)"
                    + "VALUES(?,?,?,?)";
            Connection connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

        try {
            String query = "INSERT INTO contact.fc_contact (ID_FC, ID_TYPE, TOWN, CONTACT, " +
                    "DESCRIPTION, DATE_B, POST_INDEX) VALUES(?, ?, ?, ?, ?, ?, ?)";
            Connection connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 1);
            preparedStatement.setString(3, town);
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, description);
            preparedStatement.setString(6, date);
            preparedStatement.setString(7, postIndex);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }

    }

    @Override
    public void edit(Information information) {

    }

    @Override
    public void delete(String id) {
        try {
            String query = "DELETE FROM contact.fc_face WHERE ID = " + id ;
            Connection connection = dbConnection.getConnect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    @Override
    public void selectData(ObservableList<Information> list) {
        try {
            String query = "SELECT fc_face.ID, POST, FAMILY, NAME1, NAME2, NAME, TOWN, " +
                    "CONTACT, DESCRIPTION, DATE_B, POST_INDEX " +
                    "FROM contact.fc_face LEFT JOIN contact.fc_contact fc on fc_face.ID = fc.ID_FC";
            Connection connection = dbConnection.getConnect();
            resultSet = connection.createStatement().executeQuery(query);
            while (resultSet.next()) {
                Information in = new Information();
                in.setId(resultSet.getInt(1));
                in.setPost(resultSet.getString(2));
                in.setLastName(resultSet.getString(3));
                in.setFirstName(resultSet.getString(4));
                in.setMiddleName(resultSet.getString(5));
                in.setOrganization(resultSet.getString(6));
                in.setTown(resultSet.getString(7));
                in.setContact(resultSet.getString(8));
                in.setDescription(resultSet.getString(9));
                in.setDate(resultSet.getDate(10));
                in.setPostIndex(resultSet.getString(11));
                list.add(in);
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

    @Override
    public void showDetails(Information in) {
        try {
            String query = "SELECT TOWN, CONTACT, DESCRIPTION, DATE_B, POST_INDEX " +
                    "FROM contact.fc_contact WHERE ID";
            Connection connection = dbConnection.getConnect();
            resultSet = connection.createStatement().executeQuery(query);
           while (resultSet.next()){
               in.setTown(resultSet.getString(1));
               in.setContact(resultSet.getString(2));
               in.setDescription(resultSet.getString(3));
               in.setDate(resultSet.getDate(4));
               in.setPostIndex(resultSet.getString(5));
           }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
    }

}
