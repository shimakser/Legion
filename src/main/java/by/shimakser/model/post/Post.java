package by.shimakser.model.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String anons;
    private String mainText;
    private int views;
    private String author;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    public Post() {
    }

    public Post(String title, String anons, String mainText, String author) {
        this.title = title;
        this.anons = anons;
        this.mainText = mainText;
        this.author = author;
    }
}


