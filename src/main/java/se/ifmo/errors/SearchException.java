package se.ifmo.errors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SearchException extends RuntimeException {
    public SearchException(String message) {
        super(message);
    }
}
