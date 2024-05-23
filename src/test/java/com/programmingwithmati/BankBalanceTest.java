package com.programmingwithmati;

import com.programmingwithmati.exception.InvalidAccountException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankBalanceTest {


  @Test
  void testDeposit() {
    var bankBalance = new BankBalance("acc-1", BigDecimal.TEN);
    var transaction = new Transaction("t-1", "acc-1", BigDecimal.TEN);
    var newBalance = bankBalance.processTransaction(transaction);

    assertEquals(BigDecimal.valueOf(20), newBalance.amount());
  }

  @Test
  void testTransactionIsForDifferentAccount() {
    var bankBalance = new BankBalance("acc-1", BigDecimal.TEN);
    var transaction = new Transaction("t-1", "acc-2", BigDecimal.TEN);
    assertThrows(InvalidAccountException.class, () -> bankBalance.processTransaction(transaction));
    //New test
  }
}
