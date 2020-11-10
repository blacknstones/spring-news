package sda.springnews.articles;

import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

// @Entity
public class Article {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private long id;

    private String title;
    private String body;
    private String authorName;


    protected Article() {

    }

    public Article(Long id, String title, String body, String authorName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
