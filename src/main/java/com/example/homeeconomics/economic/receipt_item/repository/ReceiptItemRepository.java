package com.example.homeeconomics.economic.receipt_item.repository;

import com.example.homeeconomics.economic.receipt_item.entity.ReceiptItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long> {
}
