package org.example.book;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchCriteria {
    private String author;
}
