package exception;

public class InvalidPetAgeException extends RuntimeException {
    public InvalidPetAgeException(String message) {
        super(message);
    }
}
