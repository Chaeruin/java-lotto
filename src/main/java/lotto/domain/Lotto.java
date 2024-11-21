package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        isInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getErrorMessage());
        }
    }

    void isDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    void isInRange(List<Integer> numbers) {
        for (Integer n : numbers) {
            if (n > 45 || n < 1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_NUMBER.getErrorMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
