package lotto;

import lotto.common.AppConfig;
import lotto.presentation.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.getLottoController();
        lottoController.lottoStart();
    }
}
