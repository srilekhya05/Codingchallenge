package dao;

import entity.model.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private Connection connection;

    public PetDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM pets");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pet pet = new Pet(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("breed")
                );
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // Add other database operations as needed
}

