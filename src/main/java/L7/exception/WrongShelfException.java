package L7.exception;

public class WrongShelfException extends RuntimeException {

    public WrongShelfException(String message){
        super(message);
    }
}
