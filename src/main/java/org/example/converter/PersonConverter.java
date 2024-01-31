package org.example.converter;

import org.example.dto.PersonDto;
import org.example.model.Person;
import org.example.model.UserType;
import org.example.dto.UserTypeDto;
public class PersonConverter extends Converter<PersonDto, Person> {
    public PersonConverter() {
        super(PersonConverter::convertToEntity, PersonConverter::convertToDto);
    }

    private static PersonDto convertToDto(Person person) {
        return PersonDto.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .userType(UserTypeDto.valueOf(person.getUserType().toString()))
                .build();
    }

    private static Person convertToEntity(PersonDto personDto) {
        return Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .userType(UserType.valueOf(personDto.getUserType().toString()))
                .build();
    }
}