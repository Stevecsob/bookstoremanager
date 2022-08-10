package com.scs.bookstoremanager.controller;



import com.scs.bookstoremanager.dto.MessageResponseDTO;
import com.scs.bookstoremanager.entity.Book;
import com.scs.bookstoremanager.repository.BookRepository;
import com.scs.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {
//    classe controller responsável pelos metodos http

    private final BookService bookService;


    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        return bookService.create(book);
    }
}
