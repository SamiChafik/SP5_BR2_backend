package com.example.budget_manager.mapper;

import com.example.budget_manager.dto.TransactionDTO;
import com.example.budget_manager.entities.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {
    public TransactionDTO toDto(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        return new TransactionDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDate(),
                transaction.getDescription(),
                transaction.getCategory()
        );
    }

    public Transaction toEntity(TransactionDTO dto) {
        if (dto == null) {
            return null;
        }

        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        transaction.setCategory(dto.getCategory());

        return transaction;
    }

    public List<TransactionDTO> toDtoList(List<Transaction> transactions) {
        return transactions.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Transaction> toEntityList(List<TransactionDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDto(TransactionDTO dto, Transaction transaction) {
        if (dto.getAmount() != null) {
            transaction.setAmount(dto.getAmount());
        }
        if (dto.getDate() != null) {
            transaction.setDate(dto.getDate());
        }
        if (dto.getDescription() != null) {
            transaction.setDescription(dto.getDescription());
        }
        if (dto.getCategory() != null) {
            transaction.setCategory(dto.getCategory());
        }
    }
}
