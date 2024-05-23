package com.programmingwithmati;

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
    assertThrows(, () -> bankBalance.processTransaction(transaction))

    assertEquals(BigDecimal.valueOf(20), newBalance.amount());
    //New test
  }
}
