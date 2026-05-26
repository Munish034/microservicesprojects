package microservices.UserServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import microservices.UserServices.payload.ApiResponse;
@RestControllerAdvice
public class GlobalExceptiomHandler {

    @ExceptionHandler(ResourcenotfounfException.class)
    public ResponseEntity<ApiResponse>  handlerResourcenotfoundException(ResourcenotfounfException ex){



String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);

    }


}
