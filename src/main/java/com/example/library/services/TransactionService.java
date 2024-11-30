package com.example.library.services;

import com.example.library.models.Transaction;
import com.example.library.models.enums.ActionType;
import com.example.library.repositories.BookRepository;
import com.example.library.repositories.TransactionRepository;
import com.example.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor

public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public void actionBook(Long userId, Long bookId, ActionType actionType) {
        Transaction transaction = new Transaction();
        transaction.setUser(userRepository.findById(userId).orElse(null));
        transaction.setBook(bookRepository.findById(bookId).orElse(null));
        transaction.setDate(LocalDateTime.now());
        transaction.setActionType(actionType);
        transactionRepository.save(transaction);
    }

}