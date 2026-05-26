package microservices.UserServices.exception;

public class ResourcenotfounfException extends RuntimeException{

    public ResourcenotfounfException(){

        super("resources not found ");
    }

    public ResourcenotfounfException(String message){
        super(message);
    }
}
