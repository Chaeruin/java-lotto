package lotto.enums;

public enum WinningResult {

    THREE_WINNING(3, 5_000, 0, false),
    FOUR_WINNING(4, 50_000, 0, false),
    FIVE_WINNING(5, 1_500_000, 0, false),
    FIVE_BONUS_WINNING(5, 30_000_000, 0 , true),
    SIX_WINNING(6, 2_000_000_000, 0, false);

    private final int count;
    private final int money;
    private int winning;
    private final boolean isBonus;

    WinningResult(int count, int money, int winning, boolean isBonus) {
        this.count = count;
        this.money = money;
        this.winning = winning;
        this.isBonus = isBonus;
    }

    public int getCount() {
        return this.count;
    }

    public int getMoney() {
        return this.money;
    }

    public int getWinning() {
        return this.winning;
    }

    public boolean getIsBonus() {
        return this.isBonus;
    }

    public void setWinning(int winning) {
        this.winning = winning;
    }


}
