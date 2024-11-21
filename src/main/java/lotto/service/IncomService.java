package lotto.service;

import lotto.domain.IncomeRate;
import lotto.domain.Money;
import lotto.enums.WinningResult;

public class IncomService {

    int sumAllIncome() {
        int sum = 0;
        sum += WinningResult.THREE_WINNING.getWinning() * WinningResult.THREE_WINNING.getMoney();
        sum += WinningResult.FOUR_WINNING.getWinning() * WinningResult.FOUR_WINNING.getMoney();
        sum += WinningResult.FIVE_WINNING.getWinning() * WinningResult.FIVE_WINNING.getMoney();
        sum += WinningResult.FIVE_BONUS_WINNING.getWinning() * WinningResult.FIVE_BONUS_WINNING.getMoney();
        sum += WinningResult.SIX_WINNING.getWinning() * WinningResult.SIX_WINNING.getMoney();

        return sum;
    }

    public IncomeRate setIncomeRate(int incomeSum, Money money) {
        return new IncomeRate(incomeSum, money.getMoney());
    }
}
