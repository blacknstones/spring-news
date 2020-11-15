package sda.springnews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    public CommentController(@Autowired CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/comments?articleId={articleId}")
    public List<Comment> getAllByArticleId(@PathVariable Long articleId) {
        return commentService.getAllByArticleId(articleId);
    }

    @PostMapping("/comments")
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("/comments")
    public Comment update(@RequestBody Comment updatedComment) {
        return commentService.update(updatedComment);
    }

    @DeleteMapping("/comments")
    public void delete(@RequestBody Long id) {
        commentService.delete(id);
    }
}
