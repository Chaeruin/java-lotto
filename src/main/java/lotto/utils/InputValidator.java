package lotto.utils;

import java.util.Arrays;
import lotto.enums.ErrorMessage;

public class InputValidator {

    public boolean isMoneyStringOrNone(String input) {
        try {
            int money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_CHAR.getErrorMessage());
        }
        return true;
    }

    // 이 로직 하나로
    // 1. 문자 포함 되었는지 2. 공백 포함 되었는지 3. 구분자 이상한거 없는지
    // 모두 검증됨
    public boolean isNumbersStringValidInput(String input) {
        String[] inputs = input.split(",");
        try {
            int[] numbers = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_CHAR.getErrorMessage());
        }
        return true;
    }

    public boolean isBonusNumberValid(String input) {
        try {
            int bonus = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_CHAR.getErrorMessage());
        }
        return true;
    }

}
