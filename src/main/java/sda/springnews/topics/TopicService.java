package sda.springnews.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepo repo;

    public List<Topic> getAll() {
        return repo.findAll();
    }

    public List<Topic> getAllByArticleId(Long articleId) {
      return repo.findAllByArticles_id(articleId);
    }

    // Use Optional in case the id doesn't exist
    public Optional<Topic> getById(Long id) {
        return repo.findById(id);
    }

    // repo will check if the id exists
    // if not, new article will be created
    public Topic create(Topic topic) {
        return repo.save(topic);
    }
    // if yes, existed article will be updated
    public Topic update(Topic updatedTopic) {
        return repo.save(updatedTopic);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
