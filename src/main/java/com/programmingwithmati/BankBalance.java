package com.programmingwithmati;

import java.math.BigDecimal;

public record BankBalance(
        String accountId,
        BigDecimal amount
) {

  BankBalance processTransaction(Transaction transaction) {
    return new BankBalance(this.accountId, this.amount.add(transaction.amount()));
  }
}
