package org.example.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RentalSearchCriteria {
    private String firstName;
    private String lastName;
}
