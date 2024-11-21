package lotto.domain;

import lotto.enums.ErrorMessage;

public class Money {
    private final int money;

    public Money(int money) {
        isZeroMoney(money);
        isThousand(money);
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    void isZeroMoney(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ZERO.getErrorMessage());
        }
    }

    void isThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_1000.getErrorMessage());
        }
    }

}
