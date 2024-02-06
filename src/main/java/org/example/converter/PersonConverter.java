package org.example.converter;

import org.example.dto.PersonDto;
import org.example.model.Person;
import org.example.model.UserType;
import org.example.dto.UserTypeDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PersonConverter extends Converter<PersonDto , Person>{
    public PersonConverter() {
        super(PersonConverter::convertToEntity, PersonConverter::convertToDto);
    }

    private static PersonDto convertToDto(Person person){
        return new PersonDto(person.getFirstName(), person.getLastName(), UserTypeDto.valueOf(person.getUserType().toString()));
    }

    private static Person convertToEntity(PersonDto dto){
        return new Person(UUID.randomUUID(), dto.getFirstName(), dto.getFirstName(), UserType.valueOf(dto.getUserType().toString()));
    }
}