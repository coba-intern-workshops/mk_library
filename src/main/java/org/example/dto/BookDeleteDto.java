package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.BookStatus;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class BookDeleteDto {
    private BookStatus status;
}