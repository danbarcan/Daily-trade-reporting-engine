package com.jpmc.test.tests;

import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

import com.jpmc.test.utils.DateUtils;

public class DateUtilsTest {

	@Test
	public void testSundayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 13);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 14);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testSundayAED() {
		LocalDate date = LocalDate.of(2018, 5, 13);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 13);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testSundaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 13);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 13);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testSaturdayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 12);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 14);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testSaturdayAED() {
		LocalDate date = LocalDate.of(2018, 5, 12);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 13);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testSaturdaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 12);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 13);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testFridayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 11);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 11);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testFridayAED() {
		LocalDate date = LocalDate.of(2018, 5, 11);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 13);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testFridaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 11);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 13);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testThursdayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 10);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 10);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testThursdayAED() {
		LocalDate date = LocalDate.of(2018, 5, 10);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 10);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testThursdaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 10);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 10);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testMondayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 14);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 14);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testMondayAED() {
		LocalDate date = LocalDate.of(2018, 5, 14);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 14);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testMondaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 14);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 14);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testTuesdayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 15);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 15);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testTuesdayAED() {
		LocalDate date = LocalDate.of(2018, 5, 15);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 15);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testTuesdaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 15);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 15);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testWednesdayNormalCurrency() {
		LocalDate date = LocalDate.of(2018, 5, 16);
		String currency = "USD";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 16);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testWednesdayAED() {
		LocalDate date = LocalDate.of(2018, 5, 16);
		String currency = "AED";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 16);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}
	
	@Test
	public void testWednesdaySAR() {
		LocalDate date = LocalDate.of(2018, 5, 16);
		String currency = "SAR";
		
		LocalDate actualDate = DateUtils.getWorkingDateForCurrency(date, currency);
		LocalDate expectedDate = LocalDate.of(2018, 5, 16);
		
		if (!actualDate.isEqual(expectedDate)) {
			fail("Expected: " + expectedDate + " received: " + actualDate);
		}
	}

}
