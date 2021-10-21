package pl.coderslab.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MockBookService implements BookOperations {
    private static Long nextId = 4L;
    private List<Book> bookList;

    public MockBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        bookList.add(book);
    }

    @Override
    public void delete(Long id) {
        if (this.findById(id).isPresent()) {
            bookList.removeIf(book -> book.getId().equals(id));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "WRONG BOOK ID ");
        }
    }

    @Override
    public void update(Book book) {
        if (this.findById(book.getId()).isPresent()) {
            int indexOf = bookList.indexOf(this.findById(book.getId()).get());
            bookList.set(indexOf, book);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "WRONG BOOK ID");
        }
    }

}
