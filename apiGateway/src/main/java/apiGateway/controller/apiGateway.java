package apiGateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiGateway {


    @GetMapping("/test")
    public String apiGateway() {
        return "API Gateway Application Started";
    }
}
