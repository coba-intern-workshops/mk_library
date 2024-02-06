package org.example.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonSearchCriteria {
    private String firstName;
    private String lastName;
}