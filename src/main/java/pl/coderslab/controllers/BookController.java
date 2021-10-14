package pl.coderslab.controllers;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@Log
@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return mockBookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws Exception {
        return this.mockBookService.findById(id).orElseThrow(() -> new Exception("Brak ksiązki o podanym id"));
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.addBook(book);
    }

    @DeleteMapping("/{id}")
        public void removeBook(@PathVariable Long id) {
            mockBookService.remove(id);
        }


}

