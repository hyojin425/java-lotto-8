package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoRankDto;
import lotto.dto.LottoResultDto;
import lotto.repository.IssuedLottoRepository;
import lotto.repository.LottoRepository;
import lotto.utils.RandomNumberGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.common.LottoConstants.LOTTO_PRICE;
import static lotto.validator.LottoServiceValidator.validatePurchaseAmount;


public class LottoService {

    final LottoRepository lottoRepository;
    final IssuedLottoRepository issuedLottoRepository;

    public LottoService(LottoRepository lottoRepository, IssuedLottoRepository issuedLottoRepository) {
        this.lottoRepository = lottoRepository;
        this.issuedLottoRepository = issuedLottoRepository;
    }

    public IssuedLottoDto buyLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int amount = purchaseAmount / LOTTO_PRICE;

        saveRandomLottos(amount);
        saveIssuedLotto(lottoRepository.findAll(), amount);

        return convertToIssuedLottoDto(lottoRepository.findAll(), amount);
    }

    private void saveRandomLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            lottoRepository.save(generateLotto());
        }
    }

    private Lotto generateLotto() {
        return new Lotto(RandomNumberGenerator.generateUniqueRandomNumber());
    }

    private void saveIssuedLotto(List<Lotto> lottos, int amount) {
        issuedLottoRepository.save(new IssuedLotto(lottos, amount));
    }

    private IssuedLottoDto convertToIssuedLottoDto(List<Lotto> lottos, int amount) {
        return IssuedLottoDto.from(convertToLottoDto(lottos), amount);
    }

    private List<LottoDto> convertToLottoDto(List<Lotto> lottos) {
        return lottos.stream()
                .map(LottoDto::from)
                .collect(Collectors.toList());
    }

    public float calculateProfitRate(Map<LottoRank, Long> rankCount, int amount) {
        int totalPrize = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue().intValue())
                .sum();

        return (float) totalPrize / (amount * LOTTO_PRICE) * 100;
    }
}
