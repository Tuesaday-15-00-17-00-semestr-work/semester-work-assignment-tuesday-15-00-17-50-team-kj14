package com.example.library.repositories;

import com.example.library.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public void deleteAllByBookId(Long bookId);
}

