package com.jpmc.test.utils;

import com.jpmc.test.beans.Trade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportUtils {

    public static Map<LocalDate, BigDecimal> getDailyTotalIncoming(List<Trade> trades) {
        Map<LocalDate, List<Trade>> dailyIncomingTradesMap = getDailyIncomingTradeList(trades);

        return sumListFromMapValue(dailyIncomingTradesMap);
    }

    public static Map<LocalDate, BigDecimal> getDailyTotalOutgoing(List<Trade> trades) {
        Map<LocalDate, List<Trade>> dailyOutgoingTradesMap = getDailyOutgoingTradeList(trades);

        return sumListFromMapValue(dailyOutgoingTradesMap);
    }

    public static List<Trade> orderIncomingTrades(List<Trade> trades) {
        List<Trade> incomingTrades = trades.stream().filter(Trade::isIncoming).collect(Collectors.toList());
        incomingTrades.sort(Comparator.comparing(Trade::computeTotal).reversed()
                .thenComparing(Trade::getInstructionDate)
                .thenComparing(Trade::getEntity));

        return incomingTrades;
    }

    public static List<Trade> orderOutgoingTrades(List<Trade> trades) {
        List<Trade> incomingTrades = trades.stream().filter(Trade::isOutgoing).collect(Collectors.toList());
        incomingTrades.sort(Comparator.comparing(Trade::computeTotal).reversed()
                .thenComparing(Trade::getInstructionDate)
                .thenComparing(Trade::getEntity));

        return incomingTrades;
    }

    private static Map<LocalDate, List<Trade>> getDailyIncomingTradeList(List<Trade> trades) {
        return trades
                .stream()
                .filter(Trade::isIncoming)
                .collect(Collectors.groupingBy(Trade::getSettlementDate));
    }

    private static Map<LocalDate, List<Trade>> getDailyOutgoingTradeList(List<Trade> trades) {
        return trades
                .stream()
                .filter(Trade::isOutgoing)
                .collect(Collectors.groupingBy(Trade::getSettlementDate));
    }

    private static Map<LocalDate, BigDecimal> sumListFromMapValue(Map<LocalDate, List<Trade>> dailyTradesMap) {
        return dailyTradesMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()
                        .stream()
                        .map(Trade::computeTotal)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)));
    }
}
