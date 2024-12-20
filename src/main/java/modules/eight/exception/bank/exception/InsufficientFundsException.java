package modules.eight.exception.bank.exception;

public class InsufficientFundsException extends Exception {

    private String message;

    public InsufficientFundsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
