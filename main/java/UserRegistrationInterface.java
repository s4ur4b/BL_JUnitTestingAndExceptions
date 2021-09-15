@FunctionalInterface
public interface UserRegistrationInterface {
    public boolean validateEntry(String name) throws UserRegException;
}
