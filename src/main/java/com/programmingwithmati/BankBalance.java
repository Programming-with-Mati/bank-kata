package com.programmingwithmati;

import com.programmingwithmati.exception.InvalidAccountException;

import java.math.BigDecimal;

public record BankBalance(
        String accountId,
        BigDecimal amount
) {

  BankBalance processTransaction(Transaction transaction) {
      validateTransaction(transaction);
      return new BankBalance(this.accountId, this.amount.add(transaction.amount()));
  }

  private void validateTransaction(Transaction transaction) {
      if (!this.accountId.equals(transaction.accountId())) {
          throw new InvalidAccountException("Invalid account for the transaction");
      }
  }
}
