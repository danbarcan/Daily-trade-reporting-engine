package com.jpmc.test.beans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.jpmc.test.enums.TransactionType;
import com.jpmc.test.utils.DateUtils;

public class Trade {

	private String entity;
	private TransactionType transactionType;
	private BigDecimal agreedFx;
	private String currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private long units;
	private BigDecimal pricePerUnit;

	public Trade() {
		super();
	}

	public Trade(String entity, TransactionType transactionType, BigDecimal agreedFx, String currency,
			LocalDate instructionDate, LocalDate settlementDate, long units, BigDecimal pricePerUnit) {
		super();
		this.entity = entity;
		this.transactionType = transactionType;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return DateUtils.getWorkingDateForCurrency(settlementDate, currency);
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public long getUnits() {
		return units;
	}

	public void setUnits(long units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	public boolean isIncoming() {
		return TransactionType.S.equals(transactionType);
	}
	
	public boolean isOutgoing() {
		return TransactionType.B.equals(transactionType);
	}
	
	public BigDecimal computeTotal() {
		BigDecimal total = pricePerUnit;
		total = total.multiply(new BigDecimal(units));
		total = total.multiply(agreedFx);
		
		return total.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return "Trade [entity=" + entity + ", transactionType=" + transactionType + ", agreedFx=" + agreedFx.setScale(2, RoundingMode.HALF_UP)
				+ ", currency=" + currency + ", instructionDate=" + instructionDate + ", settlementDate="
				+ settlementDate + ", units=" + units + ", pricePerUnit=" + pricePerUnit.setScale(2, RoundingMode.HALF_UP) + " total=" + computeTotal() +"]";
	}
}
