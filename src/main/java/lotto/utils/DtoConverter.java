package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.dto.IssuedLottoDto;
import lotto.dto.LottoDto;
import lotto.dto.LottoRankDto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DtoConverter {

    public static IssuedLottoDto convertToIssuedLottoDto(List<Lotto> lottos, int amount) {
        return IssuedLottoDto.of(convertToLottoDto(lottos), amount);
    }

    public static List<LottoDto> convertToLottoDto(List<Lotto> lottos) {
        return lottos.stream()
                .map(LottoDto::from)
                .collect(Collectors.toList());
    }

    public static List<LottoRankDto> convertToLottoRankDto(Map<LottoRank, Long> rankCount) {
        return Arrays.stream(LottoRank.values())
                .map(rank -> LottoRankDto.of(rank, rankCount.getOrDefault(rank, 0L).intValue()))
                .sorted(Comparator.comparingInt(LottoRankDto::matchCount))
                .toList();
    }
}
