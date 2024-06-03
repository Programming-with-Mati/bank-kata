package com.programmingwithmati;

import com.programmingwithmati.exception.InvalidAccountException;
import com.programmingwithmati.exception.NotEnoughFundsException;

import java.math.BigDecimal;

public record BankBalance(
        String accountId,
        BigDecimal amount
) {

    BankBalance processTransaction(Transaction transaction) {
        validateTransaction(transaction);
        return switch (transaction.type()) {
            case DEPOSIT -> new BankBalance(this.accountId, this.amount.add(transaction.amount()));
            case WITHDRAW -> {
                validateFunds(transaction);
                yield new BankBalance(this.accountId, this.amount.subtract(transaction.amount()));
            }
            case CHECK_BALANCE -> new BankBalance(this.accountId, this.amount);
        };
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
