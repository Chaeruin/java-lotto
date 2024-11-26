package lotto;

import lotto.controller.LottoController;
import lotto.service.IncomService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        IncomService incomService = new IncomService();

        LottoController lottoController = new LottoController(inputView, outputView, lottoService, incomService);

        lottoController.run();
    }
}
