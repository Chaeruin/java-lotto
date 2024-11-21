package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.WinningResult;

public class LottoService {
    public int getLottoCount(Money money) {
        return money.getMoney() / 1000;
    }

    public Lotto getLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public List<Lotto> getLottos(int count) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    public void matchNumbers(Lotto lotto, Bonus bonus, List<Lotto> lottos) {
        for (Lotto l: lottos) {
            List<Integer> result = lotto.getNumbers().stream().filter(old
                    -> l.getNumbers().stream().anyMatch(Predicate.isEqual(old))).collect(Collectors.toList());
            if (result.size() == 3) { WinningResult.THREE_WINNING.setWinning( WinningResult.THREE_WINNING.getWinning() + 1);}
            else if (result.size() == 4) { WinningResult.THREE_WINNING.setWinning( WinningResult.FOUR_WINNING.getWinning() + 1);}
            else if (result.size() == 5 && bonusMatches(l, bonus)) {
                WinningResult.FIVE_BONUS_WINNING.setWinning(WinningResult.FIVE_BONUS_WINNING.getWinning() + 1);
            } else if (result.size() == 5 && !bonusMatches(l, bonus)) {
                WinningResult.FIVE_WINNING.setWinning(WinningResult.FIVE_WINNING.getWinning() + 1);
            }
            else if (result.size() == 6) { WinningResult.THREE_WINNING.setWinning( WinningResult.SIX_WINNING.getWinning() + 1);}
        }
    }

    public boolean bonusDuplicate(Lotto lotto, Bonus bonus) {
        for (Integer ln: lotto.getNumbers()) {
            if (ln == bonus.getBonus()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.getErrorMessage());
            }
        }
        return true;
    }

    // 5개 볼이 매치하는 경우에만 그 로또 번호 lotto 객체로 가져와서 검증하면 됨
    public boolean bonusMatches(Lotto lotto, Bonus bonus) {
        for (Integer li: lotto.getNumbers()) {
            if (li == bonus.getBonus()) {
                return true;
            }
        }
        return false;
    }
}
