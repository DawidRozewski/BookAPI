package pl.coderslab.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class BadResourceException extends RuntimeException{

    public BadResourceException(String message) {
        super(message);
    }
}
