package lotto.domain;

import lotto.enums.ErrorMessage;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        isInRange(bonus);
        this.bonus = bonus;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void isInRange(int bonus) {
        if (bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_NUMBER.getErrorMessage());
        }
    }

}
