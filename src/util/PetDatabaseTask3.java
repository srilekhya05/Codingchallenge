package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

;public class PetDatabaseTask3 {
	public static void registerForAdoptionEvent(String propertyFileName) {
        String connectionString = DBPropertyUtil.getConnectionString(propertyFileName);

        try (Connection connection = DBConnUtil.getConnection(connectionString, "root", "lekhya");
             Scanner sc = new Scanner(System.in)){

          
            System.out.println("Enter participant information for Adoption Event:");
            System.out.print("Participant Name: ");
            String participant=sc.nextLine();

            System.out.print("Event ID to register for: ");
            int eventId = sc.nextInt();

            
            String sql = "INSERT INTO participant (ParticipantName, EventID) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, participant);
                preparedStatement.setInt(2, eventId);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Registration successful for Adoption Event!");
                } else {
                    System.out.println("Failed to register for Adoption Event.");
                }
            }

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
        
    }
	public static void main(String[] args) {
	PetDatabaseTask3.registerForAdoptionEvent("db.properties");
	}
}
