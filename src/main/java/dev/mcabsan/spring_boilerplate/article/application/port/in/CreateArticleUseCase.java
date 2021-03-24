package dev.mcabsan.spring_boilerplate.article.application.port.in;

public interface CreateArticleUseCase {
    ArticleDTO createArticle(CreateArticleCommand command);
}
