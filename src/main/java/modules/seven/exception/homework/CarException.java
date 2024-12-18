package modules.seven.exception.homework;

public class CarException extends Exception {
    private String message;

    public CarException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
