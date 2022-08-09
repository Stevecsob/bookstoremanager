package com.scs.bookstoremanager.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private  Integer pages;
    @Column(nullable = false)
    private Integer chapters;
    @Column(nullable = false)
    private String isbn;
    @Column(name = "publisher_name", nullable = false, unique = true)
    private String publisherName;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "author_id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
