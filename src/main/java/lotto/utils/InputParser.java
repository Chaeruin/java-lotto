package lotto.utils;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class InputParser {

    public static Money parseMoney(String input) {
        if (InputValidator.isMoneyStringOrNone(input)) {
            return new Money(Integer.parseInt(input));
        }
        return null;
    }

    public static Lotto parseLotto(String input) {
        int[] numbers = new int[6];
        if (InputValidator.isNumbersStringValidInput(input)) {
            numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        }
        return new Lotto(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    public static Bonus parseBonus(String input) {
        if (InputValidator.isBonusNumberValid(input)) {
            return new Bonus(Integer.parseInt(input));
        }
        return null;
    }
}
