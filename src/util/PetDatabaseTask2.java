package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PetDatabaseTask2 {
	public static void recordCashDonation(String propertyFileName) {
        String connectionString = DBPropertyUtil.getConnectionString(propertyFileName);

        try (Connection connection = DBConnUtil.getConnection(connectionString, "root", "lekhya");
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter donor information:");
            
            System.out.print("Donor Name: ");
            String donorName = scanner.nextLine();
            System.out.print("Donation Amount: ");
            float donationAmount = scanner.nextFloat();
            String sql = "INSERT INTO donations (Donorname, DonationAmount) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            	
            	preparedStatement.setString(1, donorName);
                preparedStatement.setFloat(2, donationAmount);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Donation recorded successfully!");
                } else {
                    System.out.println("Failed to record donation.");
                }
            }

        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
	public static void main(String[] args) {
	PetDatabaseTask2.recordCashDonation("db.properties");
	}
}
