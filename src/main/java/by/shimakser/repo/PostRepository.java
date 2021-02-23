package by.shimakser.repo;

import by.shimakser.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Iterable<Post> findAllByTitleLike(String query);
}
