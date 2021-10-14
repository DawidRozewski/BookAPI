package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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
        return new ArrayList<>(bookList);
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
    public void remove(Long id) {
        if (findById(id).isPresent()) {
            bookList.removeIf(book -> book.getId().equals(id));
        }
    }
}
