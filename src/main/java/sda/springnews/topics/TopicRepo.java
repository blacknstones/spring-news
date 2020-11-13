package sda.springnews.topics;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.springnews.articles.Article;

import java.util.List;

public interface TopicRepo extends JpaRepository<Topic, Long> {
    public List<Topic> findAllByArticleId(Long articleId);
}
