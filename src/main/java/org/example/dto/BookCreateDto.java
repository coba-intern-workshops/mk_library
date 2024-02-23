package org.example.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class BookCreateDto {
    private String title;
    private String author;
}