package org.example.service;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookSearchCriteria {
    private String author;
}