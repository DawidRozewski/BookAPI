package pl.coderslab.controllers;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;


@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@Log
@RestController
@RequestMapping("/books")
public class BookController extends RuntimeException {

    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return mockBookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws Exception {
        return this.mockBookService.findById(id).orElseThrow(() -> new Exception("Brak ksiązki o podanym id"));
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        if (isEmpty(book.getIsbn()) || isEmpty(book.getAuthor())
                || isEmpty(book.getPublisher()) || isEmpty(book.getTitle()) || isEmpty(book.getType())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "All fields must be completed"
            );
        } else {
            mockBookService.add(book);
        }
    }
        @DeleteMapping("/{id}")
        public void removeBook (@PathVariable Long id){
            mockBookService.remove(id);
        }



    private boolean isEmpty(String text) {
        return text.isEmpty();
    }
}
