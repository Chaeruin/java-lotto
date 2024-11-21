package lotto.domain;

public class IncomeRate {

    private final int income;
    private final int investment;

    public IncomeRate(int income, int investment) {
        this.income = income;
        this.investment = investment;
    }

    public int getIncome() {
        return this.income;
    }

    public int getInvestment() {
        return this.investment;
    }

    public double getIncomeRate() {
        return (double) this.income / this.investment * 100;
    }
}
