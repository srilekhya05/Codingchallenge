package main;

import java.util.Scanner;

import util.*;

public class mainmodule {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
       

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Display Pet Listings available for adoption");
            System.out.println("2. Register for Adoption Event");
            System.out.println("3. Record Cash Donation");
            System.out.println("4. Exit");

            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                	System.out.println("\n\nHere are all the pets...");
                	System.out.println("================================================");
                    PetDatabaseTasks.displayPetListings("db.properties");
                	System.out.println("================================================\n");
                    break;
                case 2:
                	System.out.println("\n\n Provide details for adoption");
                	System.out.println("================================================");
                	PetDatabaseTask3.registerForAdoptionEvent("db.properties");
                	System.out.println("================================================\n");
                    break;
                case 3:
                	System.out.println("\n\nCash donation");
                	System.out.println("================================================");
                	PetDatabaseTask2.recordCashDonation("db.properties");
                	System.out.println("================================================");
                    break;  
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static int getChoice(Scanner scanner) {
        int choice=0;
        while (true) {
        	
            
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
               
                
                break;
            
        }
        return choice;
        
    }
    }
  
