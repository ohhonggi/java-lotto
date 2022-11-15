package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class WinStatistics {
    private final Map<Rank, Long> ranks;
    private final EarningRate earnRate;

    public WinStatistics(Map<Rank, Long> ranks, EarningRate earnRate) {
        this.ranks = ranks;
        this.earnRate = earnRate;
    }

    public WinStatistics calculateWinningAmount(Amounts amount, List<Rank> ranks) {
        Map<Rank, Long> totalRank = ranks.stream().
                collect(Collectors.groupingBy(rank -> rank, counting()));

        int totalWinAmount = ranks.stream().
                map(Rank::getReward).reduce(0, Integer::sum);

        return new WinStatistics(totalRank,
                EarningRate.calculateRateOfProfit(totalWinAmount, amount));
    }

}
