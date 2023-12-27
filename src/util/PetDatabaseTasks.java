package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PetDatabaseTasks {

    public static void displayPetListings(String propertyFileName) {
        String connectionString = DBPropertyUtil.getConnectionString(propertyFileName);

        try (Connection connection = DBConnUtil.getConnection(connectionString, "root", "lekhya");
             Statement statement = connection.createStatement()) {

            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Pets WHERE AvailableForAdoption = 1");

            while (resultSet.next()) {
                
                int petId = resultSet.getInt("PetId");
                String petName = resultSet.getString("Name");
                int petAge = resultSet.getInt("Age");
                String petBreed = resultSet.getString("Breed");

                System.out.println("Pet ID: " + petId + ", Name: " + petName + ", Age: " + petAge + ", Breed: " + petBreed);
            }

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        

        
        PetDatabaseTasks.displayPetListings("db.properties");

       
        
    }
   
}

