package com.programmingwithmati;

import java.math.BigDecimal;

public record Transaction(
        String transactionId,
        String accountId,
        BigDecimal amount
) {

}
