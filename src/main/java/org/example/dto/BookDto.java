package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class BookDto {
    private String title;
    private String author;
    private BookStatusDto bookStatus;
}
