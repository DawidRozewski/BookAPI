package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBookService {

    List<Book> bookList = new ArrayList<>();

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }



}
