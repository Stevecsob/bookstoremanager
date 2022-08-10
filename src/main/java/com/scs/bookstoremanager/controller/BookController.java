package com.scs.bookstoremanager.controller;



import com.scs.bookstoremanager.dto.BookDTO;
import com.scs.bookstoremanager.dto.MessageResponseDTO;
import com.scs.bookstoremanager.entity.Book;
import com.scs.bookstoremanager.exception.BookNotFoundException;
import com.scs.bookstoremanager.repository.BookRepository;
import com.scs.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id)
            throws BookNotFoundException {
        return bookService.findById(id);
    }

}
