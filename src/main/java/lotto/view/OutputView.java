package lotto.view;

import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoRankDto;
import lotto.dto.LottoResultDto;

public class OutputView {

    public void printPurchaseAmountInputGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printIssuedLotto(IssuedLottoDto issuedLottoDto) {
        System.out.println(issuedLottoDto.amount() + "개를 구매했습니다.");

        for (LottoDto lotto : issuedLottoDto.lottoDtos()) {
            System.out.println(lotto);
        }
    }

    public void printWinningLottoInputGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRankDto lottoRankDto : lottoResultDto.lottoRanks()) {
            System.out.println(
                    lottoRankDto.matchCount() + "개 일치 (" + lottoRankDto.prize() + "원) - " + lottoRankDto.totalCount() + "개");
        }

        System.out.println("총 수익률은 " + lottoResultDto.rate() + "%입니다.");
    }
}
