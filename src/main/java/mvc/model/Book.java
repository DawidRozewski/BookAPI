package mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Book {

    private long id;
    private String isbn;
    private String title;
    private String author;
    private String pHouse;
    private String subject;

}
