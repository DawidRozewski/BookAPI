package pl.coderslab.service;
import pl.coderslab.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookOperations {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    void add(Book book);
    void delete(Long id);
    void update(Book book);
}
