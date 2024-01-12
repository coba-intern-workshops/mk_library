package org.example.model;

import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Book {
    private UUID id;
    private String title;
    private String author;
    private BookStatus bookStatus;
}
