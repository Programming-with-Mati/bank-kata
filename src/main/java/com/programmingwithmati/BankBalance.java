package com.programmingwithmati;

import com.programmingwithmati.enums.TransactionType;
import com.programmingwithmati.exception.InvalidAccountException;
import com.programmingwithmati.exception.NotEnoughFundsException;

import java.math.BigDecimal;

public record   BankBalance(
        String accountId,
        BigDecimal amount
) {

  BankBalance processTransaction(Transaction transaction) {
      validateTransaction(transaction);

      if(transaction.type().isWithdraw()){
          validateFunds(transaction);

          return new BankBalance(this.accountId, this.amount.subtract(transaction.amount()));
      }
      return new BankBalance(this.accountId, this.amount.add(transaction.amount()));
  }

    private void validateFunds(Transaction transaction) {
        if(transaction.amount().compareTo(this.amount) > 0){
            throw new NotEnoughFundsException("Insufficient balance to process transaction");
        }
    }

    private void validateTransaction(Transaction transaction) {
      if (!this.accountId.equals(transaction.accountId())) {
          throw new InvalidAccountException("Invalid account for the transaction");
      }
  }



}
