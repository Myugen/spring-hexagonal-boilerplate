package dev.mcabsan.spring_boilerplate.article.application.port.in;

import dev.mcabsan.spring_boilerplate.common.application.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateArticleCommand extends SelfValidating<CreateArticleCommand> {
    @NotBlank
    @Max(255)
    String title;

    @NotBlank
    @Min(50)
    String content;

    public CreateArticleCommand(String title, String content) {
        this.title = title;
        this.content = content;
        validateSelf();
    }
}
