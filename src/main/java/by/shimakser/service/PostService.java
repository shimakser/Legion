package by.shimakser.service;

import by.shimakser.models.Category;
import by.shimakser.models.Post;
import by.shimakser.models.Type;

import java.util.List;

public interface PostService {

    public List<Post> search(String query);

    public List<Post> add(Type type, Category category, String name, String mainText);
}
