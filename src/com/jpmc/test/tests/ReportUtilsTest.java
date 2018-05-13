package com.jpmc.test.tests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jpmc.test.beans.Trade;
import com.jpmc.test.enums.TransactionType;
import com.jpmc.test.utils.ReportUtils;

public class ReportUtilsTest {

	List<Trade> trades = new ArrayList<>();
	Trade trade1 = new Trade("bar", TransactionType.B, new BigDecimal(0.5), "USD", LocalDate.of(2018, 5, 11),
			LocalDate.of(2018, 5, 14), 200, new BigDecimal(100.25));
	
	Trade trade2 = new Trade("bar1", TransactionType.B, new BigDecimal(0.6), "USD", LocalDate.of(2018, 5, 11),
			LocalDate.of(2018, 5, 14), 300, new BigDecimal(110.25));
	
	Trade trade3 = new Trade("foo", TransactionType.S, new BigDecimal(0.5), "USD", LocalDate.of(2018, 5, 11),
			LocalDate.of(2018, 5, 14), 200, new BigDecimal(100.25));
	
	Trade trade4 = new Trade("foo1", TransactionType.S, new BigDecimal(0.6), "USD", LocalDate.of(2018, 5, 11),
			LocalDate.of(2018, 5, 14), 300, new BigDecimal(110.25));
	
	Trade trade5 = new Trade("bar2", TransactionType.B, new BigDecimal(0.5), "USD", LocalDate.of(2018, 5, 11),
			LocalDate.of(2018, 5, 15), 200, new BigDecimal(100.25));
	
	Trade trade6 = new Trade("foo2", TransactionType.S, new BigDecimal(0.5), "USD", LocalDate.of(2018, 5, 11),
			LocalDate.of(2018, 5, 15), 200, new BigDecimal(100.25));
	@Before
	public void setUp() {
		trades.add(trade1);
		
		trades.add(trade2);
		
		trades.add(trade3);
		
		trades.add(trade4);
		
		trades.add(trade5);
		
		trades.add(trade6);
	}

	@Test
	public void testDailyTotalIncome() {
		Map<LocalDate, BigDecimal> dailyTotalIncome = ReportUtils.getDailyTotalIncoming(trades);
		
		Map<LocalDate, BigDecimal> expectedDailyTotalIncome = new HashMap<>();
		expectedDailyTotalIncome.put(LocalDate.of(2018, 5, 14), trade3.computeTotal().add(trade4.computeTotal()));
		expectedDailyTotalIncome.put(LocalDate.of(2018, 5, 15), trade6.computeTotal());
		
		Assert.assertTrue("Expected: " + expectedDailyTotalIncome + " found: " + dailyTotalIncome, expectedDailyTotalIncome.equals(dailyTotalIncome));
	}
	
	@Test
	public void testDailyTotalOutcome() {
		Map<LocalDate, BigDecimal> dailyTotalOutcome = ReportUtils.getDailyTotalOutgoing(trades);
		
		Map<LocalDate, BigDecimal> expectedDailyTotalOutcome = new HashMap<>();
		expectedDailyTotalOutcome.put(LocalDate.of(2018, 5, 14), trade1.computeTotal().add(trade2.computeTotal()));
		expectedDailyTotalOutcome.put(LocalDate.of(2018, 5, 15), trade5.computeTotal());
		
		Assert.assertTrue("Expected: " + expectedDailyTotalOutcome + " found: " + dailyTotalOutcome, expectedDailyTotalOutcome.equals(dailyTotalOutcome));
	}
	
	@Test
	public void testRankingIncome() {
		List<Trade> rankingIncomeTrades = ReportUtils.orderIncomingTrades(trades);
		
		List<Trade> expectedRanking = new ArrayList<>();
		expectedRanking.add(trade4);
		expectedRanking.add(trade3);
		expectedRanking.add(trade6);
		
		Assert.assertTrue("Expected: " + expectedRanking + " found: " + rankingIncomeTrades, expectedRanking.equals(rankingIncomeTrades));
	}
	
	@Test
	public void testRankingOutcome() {
		List<Trade> rankingOutcomeTrades = ReportUtils.orderOutgoingTrades(trades);
		
		List<Trade> expectedRanking = new ArrayList<>();
		expectedRanking.add(trade2);
		expectedRanking.add(trade1);
		expectedRanking.add(trade5);
		
		Assert.assertTrue("Expected: " + expectedRanking + " found: " + rankingOutcomeTrades, expectedRanking.equals(rankingOutcomeTrades));
	}

}
