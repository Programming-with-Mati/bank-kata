package com.programmingwithmati;

import com.programmingwithmati.enums.TransactionType;

import java.math.BigDecimal;

public record Transaction(
        String transactionId,
        String accountId,
        BigDecimal amount,

        TransactionType type
) {

}
