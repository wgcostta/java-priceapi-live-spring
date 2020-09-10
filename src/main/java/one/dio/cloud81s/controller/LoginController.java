package one.dio.cloud81s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    // https://priceapi-live.herokuapp.com/api/v1/login
    @GetMapping
    public String getLogin(){
        return "Init Api";
    }

}
