package dev.mcabsan.spring_boilerplate.article.domain;

import dev.mcabsan.spring_boilerplate.common.domain.DomainException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.Instant;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Article {

    public static Article withId(ArticleId id, String title, String content, Author author) {
        return new Article(id, title, content, null, author);
    }

    public static Article withoutId(String title, String content, Author author) {
        return new Article(null, title, content, null, author);
    }

    private final ArticleId id;

    @Getter
    private final String title;

    @Getter
    private final String content;

    @Getter
    private Instant publishDate;

    @Getter
    private final Author author;

    public Optional<ArticleId> getId() {
        return Optional.ofNullable(this.id);
    }

    public void publish() {
        if (isPublished()) {
            throw new DomainException("Article is already published");
        }

        publishDate = Instant.now();
    }

    public boolean isPublished() {
        return publishDate != null;
    }

    @Value
    public static class ArticleId {
        private Long value;
    }
}
