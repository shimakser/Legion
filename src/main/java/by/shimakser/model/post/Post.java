package by.shimakser.model;

import javax.persistence.*;

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

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    public Post() {
    }

    public Post(String title, String anons, String mainText) {
        this.title = title;
        this.anons = anons;
        this.mainText = mainText;
    }

    public Post(Category category, String title, String anons, String mainText) {
        this.category = category;
        this.title = title;
        this.anons = anons;
        this.mainText = mainText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}


