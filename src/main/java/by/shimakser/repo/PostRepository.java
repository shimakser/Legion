package by.shimakser.repo;

import by.shimakser.models.Category;
import by.shimakser.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findAllByCategory(Category category);
    List<Post> findAllByOrderByIdDesc();
    List<Post> findAllByTitle(String tittle);
}