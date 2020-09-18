package one.dio.cloud81s.controller;

import lombok.AllArgsConstructor;
import one.dio.cloud81s.service.PersonService;
import one.dio.cloud81s.dto.request.PersonDTO;
import one.dio.cloud81s.entity.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

}
// https://priceapi-live.herokuapp.com/api/v1/login
/*
* {
    "firstName":"Wagner",
    "lastName": "Costa",
    "cpf":"111.111.111-72",
    "phones":[
        {
            "type":"MOBILE",
            "number": "(11)93400-2606"
        },
        {
            "type":"MOBILE",
            "number": "(18)98806-8389"
        }
    ]
}
* */