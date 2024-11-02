package com.example.libraryserver.repository;

import com.example.LibraryServer.model.Transaction;
import com.example.LibraryServer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
