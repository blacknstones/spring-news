package sda.springnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringNewsApplication {
  /*  @Autowired
    private ArticleController articleController;*/

    public static void main(String[] args) {
        SpringApplication.run(SpringNewsApplication.class, args);
    }
}
