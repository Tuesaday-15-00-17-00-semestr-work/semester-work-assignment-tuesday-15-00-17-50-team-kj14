package com.example.library.controllers;


import com.example.library.models.Book;
import com.example.library.models.enums.ActionType;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.TransactionRepository;
import com.example.library.repositories.UserRepository;
import com.example.library.services.BookService;
import com.example.library.services.TransactionService;
import com.example.library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class BookController {
    private  final BookService bookService;
    private final UserService userService;
    private final TransactionService transactionService;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @GetMapping("/")
    public String books(@RequestParam(name = "title",required = false) String title, Principal principal, Model model) {
        model.addAttribute("books",bookService.listBooks(title));
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        return "books";
    }

    @GetMapping("/books/{id}")
    public String book(@PathVariable long id,Principal principal, Model model) {
        model.addAttribute("book",bookService.getBookByID(id));
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        return "book-info";
    }

    @PostMapping("/books/create")
    public String createBook(@RequestParam String title,
                             @RequestParam String author,
                             @RequestParam String isbn,Principal principal) {

        title = title.trim();
        author = author.trim();
        isbn= isbn.trim();

        Book book = bookService.addBook(new Book(null, title, author, isbn,1));
        transactionService.actionBook(userService.getUserByPrincipal(principal).getId(),book.getId(), ActionType.ADD);
        return "redirect:/";
    }

    @PostMapping("/books/take/{id}")
    public String buyBook(@PathVariable long id,Principal principal, Model model) {
        Book book = bookService.takeBook(id);
        if(book != null){
            transactionService.actionBook(userService.getUserByPrincipal(principal).getId(),book.getId(), ActionType.TAKE);
        }
        return "redirect:/";
    }
    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id, Principal principal, Model model) {
        bookService.setBookAvailableCopies(id,0);
        transactionService.actionBook(userService.getUserByPrincipal(principal).getId(),id, ActionType.DELETE);
        return "redirect:/";
    }
}
