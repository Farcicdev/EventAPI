package dv.farcicDev.EventAPI.aplication.exeption;

public class EventAlreadyExistsException extends RuntimeException{

    public EventAlreadyExistsException(String message){
        super(message);
    }
}
