package sda.springnews.articles;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private List<Article> articles;

    public ArticleService() {
        this.articles = new ArrayList<>();
        articles.add(new Article(1L,"title1", "body1", "author1"));
        articles.add(new Article(2L,"title2", "body2", "author2"));

    }

    public List<Article> getAll() {
        return this.articles;
    }

    public Article getById(@PathVariable Long id) {
        for (Article a : articles) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Article createArticle(@RequestBody Article article) {
        articles.add(article);
        return article;
    }
}
