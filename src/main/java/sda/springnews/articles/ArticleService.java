package sda.springnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepo repo;

    public List<Article> getAll() {
        return repo.findAll();
    }

    // Use Optional in case the id doesn't exist
    public Optional<Article> getById(Long id) {
        return repo.findById(id);
    }

    // repo will check if the id exists
    // if not, new article will be created
    public Article create(Article article) {
        return repo.save(article);
    }
    // if yes, existed article will be updated
    public Article update(Article updatedArticle) {
        return repo.save(updatedArticle);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Article> getAllByTopicId(Long topicId) {
        return repo.findAllByTopics_id(topicId);
    }
}
