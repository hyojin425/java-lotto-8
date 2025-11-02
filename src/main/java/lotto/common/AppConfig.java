package lotto.common;

import lotto.presentation.LottoController;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;
import lotto.repository.IssuedLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;

public class AppConfig {

    private final LottoController lottoController;

    public AppConfig() {
        this.lottoController = lottoController();
    }

    public LottoController getLottoController() {
        return lottoController;
    }

    private LottoController lottoController() {
        return new LottoController(lottoService(), outputView(), inputView());
    }

    private LottoService lottoService() {
        return new LottoService(lottoRepository(), issuedLottoRepository());
    }

    private LottoRepository lottoRepository() {
        return new LottoRepository();
    }

    private IssuedLottoRepository issuedLottoRepository() {
        return new IssuedLottoRepository();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
