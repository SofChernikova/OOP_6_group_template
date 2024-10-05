package L5.exception;

public class WrongShelfException extends RuntimeException {

    public WrongShelfException(String message){
        super(message);
    }
}
