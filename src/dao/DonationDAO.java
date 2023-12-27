package dao;

import entity.model.Donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonationDAO {
    private Connection connection;

    public DonationDAO(Connection connection) {
        this.connection = connection;
    }

    public void recordDonation(Donation donation) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO donations (donor_name, amount) VALUES (?, ?)"
        )) {
            statement.setString(1, donation.getDonorName());
            statement.setFloat(2, donation.getAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
