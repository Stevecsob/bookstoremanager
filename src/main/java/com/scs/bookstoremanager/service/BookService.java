package com.scs.bookstoremanager.service;


import com.scs.bookstoremanager.dto.MessageResponseDTO;
import com.scs.bookstoremanager.entity.Book;
import com.scs.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
//    classe service responsável pelas regras de negócio

    private final BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create( Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder().message("Book created with ID: " + savedBook.getId()).build();

    }
}
