package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.IncomeRate;
import lotto.domain.Lotto;
import lotto.enums.WinningResult;

public class OutputView {

    public void printEnter() {
        System.out.println();
    }

    public void printLottoCountAndNumbers(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto: lottos) {
            printLottoNumbers(lotto);
        }
    }

    public void printLottoNumbers(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer ln: lotto.getNumbers()) {
            sb.append(ln);
            if (lotto.getNumbers().indexOf(ln) != lotto.getNumbers().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void printWinningLotto(IncomeRate incomeRate) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningResult winningResult: WinningResult.values()) {
            sb.append(winningResult.getCount()).append("개 일치");
            if (winningResult.getIsBonus()) { sb.append(", 보너스 볼 일치"); }
            sb.append(" (").append(df.format(winningResult.getMoney())).append("원)");
            sb.append(" - ").append(winningResult.getWinning()).append("개\n");
        }
        System.out.print(sb);
        printIncomeRate(incomeRate);
    }

    public void printIncomeRate(IncomeRate incomeRate) {
        String format = String.format("%.1f", incomeRate.getIncomeRate());
        System.out.println("총 수익률은 " + format + "%입니다.");
    }
}
