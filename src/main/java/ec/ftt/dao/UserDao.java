package ec.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ec.ftt.model.User;
import ec.ftt.util.DBUtil;

public class UserDao {

    private Connection connection;

    public UserDao() {
        connection = DBUtil.getConnection();
    } //UserDao

    public void addUser(User user) {
        
    	try {
    		
    		System.out.println("Here we are...");
    		
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO ftt.USER (NAME, EMAIL, COLOR) VALUES (?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setString(3, user.getColor());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deleteUser(Long id) {
    	
    	User user = new User();
    	user.setId(id);
    	
    	deleteUser(user);
    	
    } // deleteUser long

    public void deleteUser(User user) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM ftt.USER WHERE ID=?");
        	
        	/*
        	 * 
        	 * DELETE FROM `ftt`.`USER` WHERE <{where_expression}>;

        	 * 
        	 */
            
            // Parameters start with 1
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE USER SET NAME=?, " 
                    		                          + "EMAIL=?, " 
                    		                          + "COLOR=? " 
                                               + "WHERE ID=?");
            
            /*
             * 
             * UPDATE `ftt`.`USER`
				SET
					`ID` = <{ID: }>,
					`NAME` = <{NAME: }>,
					`EMAIL` = <{EMAIL: }>,
					`COLOR` = <{COLOR: }>
					WHERE `ID` = <{expr}>;

             * 
             */
            
            // Parameters start with 1
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setString(3, user.getColor());
            
            preparedStatement.setLong(4, user.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<User> getAllUser() {
        
    	List<User> userList = new ArrayList<User>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM USER");
            while (rs.next()) {
                
            	User user = new User();
                
            	user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                //user.setDob(rs.getDate("DOB"));
                user.setColor(rs.getString("COLOR"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    } //getAllUser

    public User getUserById(Long id) {
    	
    	User user = new User();
    	user.setId(id);
    	
    	return getUserById(user);
    	
    } // getUserById long
    
    
    	
    public User getUserById(User user) {

    	User userOutput = new User();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from USER WHERE ID=?");
            
            preparedStatement.setLong(1, user.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	userOutput.setId(rs.getLong("ID"));
            	userOutput.setName(rs.getString("NAME"));
            	userOutput.setEmail(rs.getString("EMAIL"));
            	//userOutput.setDob(rs.getDate("DOB"));
            	userOutput.setColor(rs.getString("COLOR"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userOutput;
    } //getUserById
    
    public String getDbDate() {

    	String output="";
    	
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT now() NOW");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	output = rs.getString("NOW");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    } //getDbDate
    
} //UserDao