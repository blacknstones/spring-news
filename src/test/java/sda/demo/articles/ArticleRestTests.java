package sda.demo.articles;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import sda.springnews.articles.Article;
import sda.springnews.articles.ArticleService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleRestTests {

    @Autowired
    TestRestTemplate testRestTemplate; // Test HTTP request

    @Autowired
    ArticleService articleService;

    @Test
    public void testGetAllReturnEmptyArray() {
        // Arrange

        // Act
        Article[] responseArticles = testRestTemplate.getForObject("/articles", Article[].class);

        // Assert
        Assertions.assertEquals(0, responseArticles.length);

        // this test will work too:
        // String responseArticles = testRestTemplate.getForObject("/articles", String.class);
        // Assertions.assertEquals("[]", responseArticles);
    }

    @Test
    public void testCreate() {
        // Arrange
        Article requestArticle = new Article(null, "test title", "test body", "test author");

        // Act
        Article responseArticle = testRestTemplate.postForObject("/articles", requestArticle, Article.class);

        // Assert
        Assertions.assertEquals(requestArticle.getTitle(), responseArticle.getTitle());
        Assertions.assertEquals(requestArticle.getBody(), responseArticle.getBody());

        // Check product is added
        Article getByIdArticleResponse = testRestTemplate.getForObject("/articles", Article.class);
        Assertions.assertEquals(requestArticle.getTitle(), getByIdArticleResponse.getTitle());
        Assertions.assertEquals(requestArticle.getBody(), getByIdArticleResponse.getBody());

        // Clean up
        testRestTemplate.delete("/articles" + responseArticle.getId().toString());
    }

    @Test
    public void testUpdate() {
        // Arrange
        Article originalArticle = articleService.create(new Article( null,"test title", "test body", "test author"));
        Article updatedArticle = new Article(null, "test updated title", "test updated body", "test updated author");

        // Act
        Article responseArticle = putForArticle(updatedArticle);

        // Assert
        Assertions.assertEquals(updatedArticle.getTitle(), responseArticle.getTitle());
        Assertions.assertEquals(updatedArticle.getBody(), responseArticle.getBody());

        Article getByIdArticleResponse = testRestTemplate.getForObject("/articles/" + updatedArticle.getId().toString(), Article.class);
        Assertions.assertEquals(updatedArticle.getTitle(), getByIdArticleResponse.getTitle());
        Assertions.assertEquals(updatedArticle.getBody(), getByIdArticleResponse.getBody());
    }
    
    // Helper method
    private Article putForArticle(Article requestBody) {
        HttpEntity<Article> requestEntity = new HttpEntity<>(requestBody);
        HttpEntity<Article> response = testRestTemplate.exchange("/articles", HttpMethod.PUT, requestEntity, Article.class);
        return response.getBody();

    }
}
