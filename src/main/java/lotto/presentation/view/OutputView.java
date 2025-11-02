package lotto.presentation.view;

import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoRankDto;
import lotto.dto.LottoResultDto;
import java.text.NumberFormat;
import java.util.Locale;

public class OutputView {

    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

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
        printLottoResultHeader();
        lottoResultDto.lottoRanks().forEach(this::printLottoRankLine);
        printProfitRate(lottoResultDto.rate());
    }

    private void printLottoResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printLottoRankLine(LottoRankDto rank) {
        String bonusText = getBonusText(rank);
        String prizeFormatted = formatPrize(rank.prize());
        System.out.println(rank.matchCount() + "개 일치" + bonusText + " ("
                + prizeFormatted + "원) - " + rank.totalCount() + "개");
    }

    private String getBonusText(LottoRankDto rank) {
        if (rank.bonusMatch()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String formatPrize(int prize) {
        return numberFormat.format(prize);
    }

    private void printProfitRate(float rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
