package org.example.model;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    private UUID id;
    private String firstName;
    private String lastName;
    private UserType userType;
}
