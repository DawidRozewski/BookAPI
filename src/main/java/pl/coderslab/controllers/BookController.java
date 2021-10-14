package pl.coderslab.controllers;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
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
        return mockBookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws Exception {
        return this.mockBookService.findById(id).orElseThrow(() -> new Exception("Brak ksiązki o podanym id"));
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        mockBookService.add(book);
    }

    @DeleteMapping("/{id}")
        public void removeBook(@PathVariable Long id) {
            mockBookService.remove(id);
        }


}

