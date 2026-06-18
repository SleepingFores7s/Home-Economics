package com.example.homeeconomics.economic.receipt.repository;

import com.example.homeeconomics.economic.receipt.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
