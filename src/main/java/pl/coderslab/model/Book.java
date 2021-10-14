package pl.coderslab.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;

//    need an empty constructor to allow for Jackson to perform it's deserialization actions correctly.
    public Book() {

    }



}
