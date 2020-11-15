package sda.springnews.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sda.springnews.articles.Article;
import sda.springnews.articles.ArticleService;

import java.util.List;


    @RestController
    public class TopicController {

        private TopicService topicService;

        public TopicController(@Autowired TopicService topicService) {
            this.topicService = topicService;
        }

        @GetMapping("/topics")
        public List<Topic> getAll() {
            return topicService.getAll();
        }

        @GetMapping("/topics?articleId={articleId}")
        public List<Topic> getAllByArticleId(Long articleId) {
            return topicService.getAllByArticleId(articleId);
        }

        // Create a new topic
        @PostMapping("/topics")
        public Topic create(@RequestBody Topic topic) {
            return topicService.create(topic);
        }

        @PutMapping("/topics")
        public Topic update(@RequestBody Topic updatedTopic) {
            return topicService.update(updatedTopic);
        }

        @DeleteMapping("/topics/{id}")
        public void delete(@RequestBody Long id) {
            topicService.delete(id);
        }

}
