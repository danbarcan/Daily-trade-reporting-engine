package com.jpmc.test.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.test.beans.Trade;
import com.jpmc.test.enums.TransactionType;

public class TradeTest {
	BigDecimal fx = new BigDecimal(0.5);
	BigDecimal pricePerUnit = new BigDecimal(100.25);
	int units = 200;
	Trade trade;
	
	@Before
	public void setUp() {
		trade = new Trade("foo", TransactionType.B, fx, "SGP", LocalDate.now(), LocalDate.now(), units, pricePerUnit);
	}

	@Test
	public void testComputeTotal() {
		BigDecimal expectedRes = fx.multiply(pricePerUnit).multiply(new BigDecimal(units)).setScale(2, RoundingMode.HALF_UP);
		BigDecimal actualRes = trade.computeTotal();
		if (!actualRes.equals(expectedRes)) {
			fail("Expected: " + expectedRes + " found: " + actualRes);
		}
	}

}
