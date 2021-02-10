package by.shimakser.repo;

import by.shimakser.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    Iterable<Message> findAllByTitleLike(String query);
}
