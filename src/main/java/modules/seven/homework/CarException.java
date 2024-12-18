package modules.seven.homework;

public class CarException extends Exception {
    private String message;

    CarException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
