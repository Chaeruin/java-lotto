package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.IncomeRate;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.IncomService;
import lotto.service.LottoService;
import lotto.utils.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    final InputView inputView;
    final OutputView outputView;
    final LottoService lottoService;
    final IncomService incomService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, IncomService incomService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.incomService = incomService;
    }

    public void run() {
        Money money = inputMoneyHandler();
        int count = lottoService.getLottoCount(money);
        outputView.printEnter();

        List<Lotto> lottos = lottoService.getLottos(count);
        outputView.printLottoCountAndNumbers(count, lottos);
        outputView.printEnter();

        Lotto lotto = inputLottoHandler();
        outputView.printEnter();
        Bonus bonus = inputBonusHandler(lotto);
        outputView.printEnter();

        lottoService.matchNumbers(lotto, bonus, lottos);

        IncomeRate incomeRate = incomService.setIncomeRate(incomService.sumAllIncome(), money);
        outputView.printWinningLotto(incomeRate);
    }

    public Money inputMoneyHandler() {
        Money money = null;
        while (money == null) {
            try {
                money = InputParser.parseMoney(inputView.getMoney());
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public Lotto inputLottoHandler() {
        Lotto lotto = null;
        while (lotto == null) {
            try {
                lotto = InputParser.parseLotto(inputView.getLottoNumber());
                return lotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    public Bonus inputBonusHandler(Lotto lotto) {
        Bonus bonus = null;
        boolean isNotDuplicate = false;
        while (bonus == null && !isNotDuplicate) {
            try {
                bonus = InputParser.parseBonus(inputView.getBonusNumber());
                isNotDuplicate = lottoService.bonusDuplicate(lotto, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }
}
