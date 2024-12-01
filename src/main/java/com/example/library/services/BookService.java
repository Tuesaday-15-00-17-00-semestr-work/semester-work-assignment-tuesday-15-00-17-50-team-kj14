package com.example.library.services;
import com.example.library.models.Book;
import com.example.library.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final TransactionService transactionService;
    public  List<Book> listBooks(String title) {
        if(title != null && !title.isEmpty()) {
            return bookRepository.findByTitle(title);
        }
        return bookRepository.findAll();
    }


    public Book addBook(Book book) {
        log.info("Adding book {}", book.getTitle());
        Book book1 = bookRepository.findByTitleAndAuthorAndIsbn(book.getTitle(), book.getAuthor(), book.getIsbn());

        if (book1 != null) {
            book1.setAvailable_copies(book.getAvailable_copies()+1);
            bookRepository.save(book1);
            return book1;
        }else {
            bookRepository.save(book);
            return book;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    public  Book getBookByID(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public Book takeBook(long id) {
        Book book = getBookByID(id);
        if(book != null && book.getAvailable_copies() > 0) {
            book.setAvailable_copies(book.getAvailable_copies() - 1);
            bookRepository.save(book);
            return book;
        }else {
            return null;
        }
    }
}
