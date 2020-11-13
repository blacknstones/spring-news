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
        @Autowired
        private TopicService topicService;

        @GetMapping("/topics")
        public List<Topic> getAll() {
            return topicService.getAll();
        }

        // 200 or 404
        @GetMapping("/topics/topicId={topicId}")
        public Topic getById(@PathVariable Long id) {
            return topicService.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        // Create a new topic
        @PostMapping("/topics")
        public Topic create(@RequestBody Topic topic) {
            return topicService.create(topic);
        }

        @PutMapping("/topics")
        public Topic update(@RequestBody Topic topic) {
            return topicService.update(topic);
        }

        @DeleteMapping("/topics/{id}")
        public void delete(@RequestBody Long id) {
            topicService.delete(id);
        }

}
