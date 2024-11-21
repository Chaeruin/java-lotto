package lotto.enums;

public enum ErrorMessage {

    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_INPUT_ZERO("[ERROR] 0원은 입력할 수 없습니다."),
    INVALID_INPUT_PARAMETER("[ERROR] 구분자 입력이 올바르지 않습니다."),
    INVALID_NUMBER_DUPLICATE("[ERROR] 숫자는 중복될 수 없습니다."),
    INVALID_INPUT_CHAR("[ERROR] 문자는 입력할 수 없습니다"),
    INVALID_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_INPUT_NONE("[ERROR] 입력된 값이 없습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
