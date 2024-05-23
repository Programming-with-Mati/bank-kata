package com.programmingwithmati;

import com.programmingwithmati.enums.TransactionType;
import com.programmingwithmati.exception.InvalidAccountException;
import com.programmingwithmati.exception.NotEnoughFundsException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankBalanceTest {


  @Test
  void testDeposit() {
    var bankBalance = new BankBalance("acc-1", BigDecimal.TEN);
    var transaction = new Transaction("t-1", "acc-1", BigDecimal.TEN, TransactionType.DEPOSIT);
    var newBalance = bankBalance.processTransaction(transaction);

    assertEquals(BigDecimal.valueOf(20), newBalance.amount());
  }

  @Test
  void testTransactionIsForDifferentAccount() {
    var bankBalance = new BankBalance("acc-1", BigDecimal.TEN);
    var transaction = new Transaction("t-1", "acc-2", BigDecimal.TEN, TransactionType.DEPOSIT);
    assertThrows(InvalidAccountException.class, () -> bankBalance.processTransaction(transaction));

  }


  @Test
  void givenValidAmount_whenWithdraw_thenWithdrawTheAmountFromBalance(){
    var bankBalance = new BankBalance("acc-1", BigDecimal.valueOf(100));
    var transaction = new Transaction("t-1", "acc-1", BigDecimal.TEN, TransactionType.WITHDRAW);
    var newBalance = bankBalance.processTransaction(transaction);

    assertEquals(BigDecimal.valueOf(90), newBalance.amount());
  }

  @Test
  void givenInValidAmount_whenWithdraw_thenExpectException(){
    var bankBalance = new BankBalance("acc-1", BigDecimal.valueOf(100));
    var transaction = new Transaction("t-1", "acc-1", BigDecimal.valueOf(200.00), TransactionType.WITHDRAW);

    assertThrows(NotEnoughFundsException.class, () -> bankBalance.processTransaction(transaction));
  }
}
