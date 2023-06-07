package com.jpqlquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookRunner implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Book book = new Book();
        book.setIsbn("0-2435-9373-9");
        book.setAuthor("James Gosling");
        book.setTitle("Core Java");
        book.setStatus(true);

        Book book1 = new Book();
        book1.setIsbn("0-780-679-9");
        book1.setAuthor("Ryan");
        book1.setTitle("DeadPool");
        book1.setStatus(true);

        // List<Book> books = List.of(book,book1);
        bookRepository.saveAll(List.of(book,book1));

//      List<Book> bookk = bookRepository.getAllBooks();
//      bookk.forEach(System.out::println);
//
//      bookRepository.getAllBooks().forEach(System.out::println);
//
//      System.out.println(bookRepository.getByTitle("Core Java"));
//
//      bookRepository.getByTitleAndAuthor("DeadPool","Ryan").forEach(System.out::println);

        bookRepository.getByTitleOrAuthor("DeadPool","James Gosling").forEach(System.out::println);

    }
}
