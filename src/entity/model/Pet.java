package entity.model;
import exception.*;

public class Pet {
    private String name;
    private int age;
    private String breed;

    public Pet(String name, int age, String breed) {
    	
    	if(name==null)
    	{
    		throw new NullReferenceException("Name should not be null");
    	
    	}
    	this.name = name;
    	
        if (age <= 0) {
        	throw new InvalidPetAgeException("Age must be greater than 0.");
        }
        this.age = age;
        if(breed==null)
    	{
    		throw new NullReferenceException("type of breed should not be null");
    	
    	}
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new InvalidPetAgeException("Age must be greater than 0.");
        }
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String toString() {
        return "Pet{name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }

    public static void main(String[] args) {
        try {
            Pet p = new Pet(null, 12, "german");
            System.out.println(p.toString());
        } catch (InvalidPetAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (NullReferenceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
