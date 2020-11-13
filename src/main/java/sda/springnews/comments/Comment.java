package sda.springnews.comments;

import sda.springnews.articles.Article;
import sda.springnews.topics.Topic;

import javax.persistence.*;

@Entity //indicate that this object will be stored in database
@Table(name = "comments")
public class Comment {

    @Id
    // Indicate that this value will be automatically created by database as an identity key for the object
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String authorName;

    @ManyToOne
    private Article article;

    // Default constructor
    protected Comment() { }

    public Comment(Long id, String body, String authorName) {
        this.id = id;
        this.body = body;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }
}

