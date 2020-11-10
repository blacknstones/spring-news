package sda.springnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ArticleController {
    // Use @Autowired annotation to inject dependency
    @Autowired
    private ArticleService articleService;

   /* public ArticleController() {
        this.articleService = new ArticleService();
    }*/

    // Get a list of all articles
    @GetMapping("/articles")
    public List<Article> getAll() {
        return articleService.getAll();
    }

    // Get an article by its id
    @GetMapping("/articles/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    // Create a new article
    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }
}
