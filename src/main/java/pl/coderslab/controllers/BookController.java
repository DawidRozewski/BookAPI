package pl.coderslab.controllers;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping()
    public List<Book> getAllBooks() {
        return mockBookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws Exception {
        return this.mockBookService.findById(id).orElseThrow(() -> new Exception("Brak ksiązki o podanym id"));

    }
}
