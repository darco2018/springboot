package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

// The first step of defining Spring Beans is by adding the right annotation - @Component or @Service or @Repository.
@RestController
public class BookController {

    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BookController.class);

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        System.out.println("ooooooooooooooooooooooooooo BBKKKKKK Book controller called >>>>>>>>>>>>>>>>");
        logger.trace("ooooooooooooooooooooooooooo BBKKKKKK Book controller  trace log message");
        logger.debug("ooooooooooooooooooooooooooo BBKKKKKK Book controller  Debug log message");
        logger.info("ooooooooooooooooooooooooooo BBKKKKKK Book controller  Info log message");
        logger.warn("ooooooooooooooooooooooooooo BBKKKKKK Book controller  Warn log message");
        logger.error("ooooooooooooooooooooooooooo BBKKKKKK Book controller  Error log message");
        return Arrays.asList(
                new Book(1l, "Mastering Spring 777", "John Browny")
        );
    }
}

