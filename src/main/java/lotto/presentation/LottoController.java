package lotto.presentation;

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
        int purchaseAmount = getPurchaseAmount();
        printIssuedLotto(purchaseAmount);

        List<Integer> winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();
        printLottoResult(winningLotto, bonusNumber);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                outputView.printPurchaseAmountInputGuide();
                return inputView.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printIssuedLotto(int purchaseAmount) {
        IssuedLottoDto issuedLotto = lottoService.buyLottos(purchaseAmount);
        outputView.printIssuedLotto(issuedLotto);
    }

    private List<Integer> getWinningLotto() {
        while (true) {
            try {
                outputView.printWinningLottoInputGuide();
                return inputView.getWinningLotto();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberInputGuide();
                return inputView.getBonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printLottoResult(List<Integer> winningLotto, int bonusNumber) {
        LottoResultDto lottoResult = lottoService.getLottoResult(winningLotto, bonusNumber);
        outputView.printLottoResult(lottoResult);
    }
}
