package lotto.presentation;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoResultDto;
import lotto.presentation.view.InputView;
import lotto.presentation.view.OutputView;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(LottoService lottoService, OutputView outputView, InputView inputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void lottoStart() {
        printIssuedLotto();
        printLottoResult();
    }

    private void printIssuedLotto() {
        while (true) {
            try {
                int purchaseAmount = getPurchaseAmount();
                IssuedLottoDto issuedLotto = lottoService.buyLottos(purchaseAmount);
                outputView.printIssuedLotto(issuedLotto);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getPurchaseAmount() {
        outputView.printPurchaseAmountInputGuide();
        return inputView.getPurchaseAmount();
    }

    private void printLottoResult() {
        Lotto lotto = getWinningLotto();
        LottoResult lottoResult = getLottoResult(lotto);
        LottoResultDto lottoResultDto = lottoService.getLottoResult(lottoResult);
        outputView.printLottoResult(lottoResultDto);
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                outputView.printWinningLottoInputGuide();
                List<Integer> winningLotto = inputView.getWinningLotto();
                return lottoService.createWinningLotto(winningLotto);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoResult getLottoResult(Lotto lotto) {
        while (true) {
            try {
                outputView.printBonusNumberInputGuide();
                int bonusNumber = inputView.getBonusNumber();
                return lottoService.createLottoResult(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
