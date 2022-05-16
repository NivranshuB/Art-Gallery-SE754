package A4.G2.service.account;

/**
 * An exception that is thrown when a user tries to choose a password that is not strong enough.
 */
public class IncorrectPasswordException extends Exception{
    public IncorrectPasswordException(String errorMessage) {
        super(errorMessage);
    }
}