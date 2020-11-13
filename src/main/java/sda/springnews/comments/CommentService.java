package sda.springnews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepo repo;

    public List<Comment> getAll() {
        return repo.findAll();
    }

    public List<Comment> getAllByArticleId(Long articleId) {
        return repo.findAllByArticleId(articleId);
    }

    public Comment create(Comment comment) {
        return repo.save(comment);
    }

    public Comment update(Comment updatedComment) {
        return repo.save(updatedComment);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
