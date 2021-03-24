package dev.mcabsan.spring_boilerplate.article.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Author {

    private final AuthorId id;

    @Getter
    private final String name;

    public Optional<AuthorId> getId() {
        return Optional.ofNullable(id);
    }

    @Value
    public static class AuthorId {
        private Long value;
    }
}
