package entity.model;

import exception.AdoptionException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PetShelter {
    private List<Pet> availablePets;

    static {
        try { FileInputStream file = new FileInputStream("availablepets.properties");
            Properties prop = new Properties();
            prop.load(file);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public PetShelter() {
        this.availablePets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }

    public void removePet(Pet pet) {
        availablePets.remove(pet);
    }

    public void listAvailablePets() {
        for (Pet pet : availablePets) {
            System.out.println(pet);
        }
    }

    public void adoptPet(Pet pet) {
        try {
            if (!availablePets.contains(pet)) {
                throw new AdoptionException("Pet is not available for adoption.");
            }
            
            

        } catch (AdoptionException ex) {
            System.out.println("Adoption Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        PetShelter petShelter = new PetShelter();

        Pet dog1 = new Dog("Buddy", 3, "Labrador", "Golden Retriever");
        Pet cat1 = new Cat("Whiskers", 2, "Siamese", "White");

        petShelter.addPet(dog1);
        petShelter.addPet(cat1);

        petShelter.listAvailablePets();

        
    }
}
