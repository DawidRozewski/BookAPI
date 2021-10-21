package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookOperations;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController extends RuntimeException {

    private final BookOperations bookOperations;

    public BookController(BookOperations bookOperations) {
        this.bookOperations = bookOperations;
    }


    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookOperations.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws Exception {
        return this.bookOperations.findById(id).orElseThrow(() -> new Exception("WRONG BOOK ID"));
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        if (isEmpty(book.getIsbn()) || isEmpty(book.getAuthor()) ||
            isEmpty(book.getPublisher()) || isEmpty(book.getTitle()) || isEmpty(book.getType())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "ALL FIELDS MUST BE COMPLETED"
            );
        } else {
            bookOperations.add(book);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) throws Exception {
        bookOperations.delete(id);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book) {
        bookOperations.update(book);
    }

    private boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }
}
