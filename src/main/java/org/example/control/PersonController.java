package org.example.control;

import lombok.RequiredArgsConstructor;
import org.example.dto.PersonDto;
import org.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> findAllPersons(){
        return ResponseEntity.ok(personService.findAllPersons());
    }
}