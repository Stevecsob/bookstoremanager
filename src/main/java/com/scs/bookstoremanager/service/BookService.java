package com.scs.bookstoremanager.service;


import com.scs.bookstoremanager.dto.BookDTO;
import com.scs.bookstoremanager.dto.MessageResponseDTO;
import com.scs.bookstoremanager.entity.Book;
import com.scs.bookstoremanager.exception.BookNotFoundException;

import com.scs.bookstoremanager.mapper.BookMapper;
import com.scs.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
//    classe service responsável pelas regras de negócio

    private final BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder().message("Book created with ID: " + savedBook.getId()).build();

    }

    public BookDTO findById(Long id)
            throws BookNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
