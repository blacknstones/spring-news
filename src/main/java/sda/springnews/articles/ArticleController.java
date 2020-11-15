package sda.springnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class ArticleController {
    private ArticleService articleService;

    // Use @Autowired annotation to inject dependency
    public ArticleController(@Autowired ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public List<Article> getAll() {
            return articleService.getAll();
        }

    // 200 or 404
    @GetMapping("/articles/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

   @GetMapping("/articles?topicId={topicId}")
    public List<Article> getAllByTopicId(Long topicId) {
        return articleService.getAllByTopicId(topicId);
    }

    // Create a new article
    @PostMapping("/articles")
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("/articles")
    public Article update(@RequestBody Article updatedArticle) {
        return articleService.update(updatedArticle);
    }

    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
