package groupB.newbankV5.mockcreditcardnetwork.exceptions;

public class ExpirationDateException extends RuntimeException {

    public ExpirationDateException() {
        super();
    }

    public ExpirationDateException(String message) {
        super(message);
    }

    public ExpirationDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
