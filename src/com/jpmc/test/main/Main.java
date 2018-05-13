package com.jpmc.test.main;

import com.jpmc.test.beans.Trade;
import com.jpmc.test.enums.TransactionType;
import com.jpmc.test.utils.ReportUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        List<Trade> trades = createTrades();

        Map<LocalDate, BigDecimal> dailyTotalIncomingMap = ReportUtils.getDailyTotalIncoming(trades);
        displayReportDailyTotal(dailyTotalIncomingMap, "Report daily incoming trades");

        Map<LocalDate, BigDecimal> dailyTotalOutgoingMap = ReportUtils.getDailyTotalOutgoing(trades);
        displayReportDailyTotal(dailyTotalOutgoingMap, "Report daily outgoing trades");

        List<Trade> rankingIncomingTrades = ReportUtils.orderIncomingTrades(trades);
        displayRankingIncomingTrades(rankingIncomingTrades, "Ranking incoming trades");

        List<Trade> rankingOutgoingTrades = ReportUtils.orderOutgoingTrades(trades);
        displayRankingIncomingTrades(rankingOutgoingTrades, "Ranking outgoing trades");
    }

    private static List<Trade> createTrades() {
        List<Trade> trades = new ArrayList<>();
        LocalDate refDate = LocalDate.now();

        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            trades.add(new Trade("Trade " + i, random < 0.5 ? TransactionType.B : TransactionType.S, new BigDecimal(random),
                    random > 0.6 ? "USD" : random > 0.3 ? "SGP" : "AED", refDate, refDate.plusDays(5),
                    (int) (random * 1000), new BigDecimal(Math.pow(10000, random))));
            if (random > 0.5) {
                refDate = refDate.plusDays(1);
            }
        }

        return trades;
    }

    private static void displayReportDailyTotal(Map<LocalDate, BigDecimal> dailyTotalMap, String title) {
        System.out.println(title);
        dailyTotalMap.forEach((key, value) -> System.out.println(String.format("Date %s => total: %s", key,
                    String.format("%10s", value))));
    }

    private static void displayRankingIncomingTrades(List<Trade> trades, String title) {
        System.out.println(title);
        AtomicInteger i = new AtomicInteger(1);
        trades.forEach(entry -> System.out.println(String.format("%s -> total: %s",
                    String.format("%-15s", i.getAndIncrement() + ". " + entry.getEntity()),
                    String.format("%10s", entry.computeTotal()))));
    }

}
