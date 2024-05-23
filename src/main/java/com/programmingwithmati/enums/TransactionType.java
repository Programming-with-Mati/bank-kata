package com.programmingwithmati.enums;

public enum TransactionType {

    DEPOSIT,
    WITHDRAW;

    public boolean isWithdraw() {
        return this == TransactionType.WITHDRAW;
    }

}
