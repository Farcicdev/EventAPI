package dv.farcicDev.EventAPI.aplication.exeption;

public class EventNotFoundExeption extends RuntimeException{

    public EventNotFoundExeption(String message) {
        super(message);
    }
}
