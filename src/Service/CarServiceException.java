package Service;

public class CarServiceException extends RuntimeException {
    public CarServiceException(String message){
        super("CarServiceException " + message);
    }
}