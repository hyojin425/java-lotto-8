package lotto.presentation.view;

import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoRankDto;
import lotto.dto.LottoResultDto;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static lotto.common.MessageConstant.*;

public class OutputView {
    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printPurchaseAmountInputGuide() {
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE);
    }

    public void printIssuedLotto(IssuedLottoDto issuedLottoDto) {
        System.out.printf((PURCHASED_LOTTO_COUNT_FORMAT) + "%n", issuedLottoDto.amount());

        for (LottoDto lotto : issuedLottoDto.lottoDtos()) {
            System.out.println(lotto.numbers());
        }
    }

    public void printWinningLottoInputGuide() {
        System.out.println(INPUT_WINNING_NUMBERS_GUIDE);
    }

    public void printBonusNumberInputGuide() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE);
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        printLottoResultHeader();
        sortLottoRanks(lottoResultDto.lottoRanks())
                .forEach(this::printLottoRankLine);
        printProfitRate(lottoResultDto.rate());
    }

    private void printLottoResultHeader() {
        System.out.println(RESULT_HEADER);
        System.out.println(RESULT_DIVIDER);
    }

    private List<LottoRankDto> sortLottoRanks(List<LottoRankDto> lottoRanks) {
        return lottoRanks.stream()
                .sorted(Comparator.comparingInt(LottoRankDto::matchCount)
                        .thenComparing(LottoRankDto::bonusMatch))
                .toList();
    }

    private void printLottoRankLine(LottoRankDto rank) {
        String bonusText = getBonusText(rank);
        String prizeFormatted = formatPrize(rank.prize());
        System.out.printf((MATCH_COUNT_FORMAT) + "%n",
                rank.matchCount(), bonusText, prizeFormatted, rank.totalCount());
    }

    private String getBonusText(LottoRankDto rank) {
        return rank.bonusMatch() ? BONUS_MATCH_TEXT : "";
    }

    private String formatPrize(int prize) {
        return numberFormat.format(prize);
    }

    private void printProfitRate(float rate) {
        System.out.printf((PROFIT_RATE_FORMAT) + "%n", rate);
    }
}
