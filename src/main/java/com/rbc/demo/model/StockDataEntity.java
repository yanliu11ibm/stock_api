package com.rbc.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_data")
public class StockDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quarter")
	private String quarter;

	@Column(name = "stock", nullable = false, length = 200)
	private String stock;

	@Column(name = "date")
	private String date;

	@Column(name = "open")
	private String open;

	@Column(name = "high")
	private String high;

	@Column(name = "low")
	private String low;

	@Column(name = "close")
	private String close;

	@Column(name = "volume")
	private Long volume;

	@Column(name = "percent_change_price")
	private Double percentChangePrice;

	@Column(name = "percent_change_volume_over_last_wk")
	private Double percentChangeVolumeOverLastWk;

	@Column(name = "previous_weeks_volume")
	private Long previousWeeksVolume;

	@Column(name = "next_weeks_open")
	private String nextWeeksOpen;

	@Column(name = "next_weeks_close")
	private String nextWeeksClose;

	@Column(name = "percent_change_next_weeks_price")
	private Double percentChangeNextWeeksPrice;

	@Column(name = "days_to_next_dividend")
	private Integer daysToNextDividend;

	@Column(name = "percent_return_next_dividend")
	private Double percentReturnNextDividend;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Double getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(Double percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public Double getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(Double percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public Long getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(Long previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}

	public String getNextWeeksOpen() {
		return nextWeeksOpen;
	}

	public void setNextWeeksOpen(String nextWeeksOpen) {
		this.nextWeeksOpen = nextWeeksOpen;
	}

	public String getNextWeeksClose() {
		return nextWeeksClose;
	}

	public void setNextWeeksClose(String nextWeeksClose) {
		this.nextWeeksClose = nextWeeksClose;
	}

	public Double getPercentChangeNextWeeksPrice() {
		return percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(Double percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public Integer getDaysToNextDividend() {
		return daysToNextDividend;
	}

	public void setDaysToNextDividend(Integer daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public Double getPercentReturnNextDividend() {
		return percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(Double percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDataEntity other = (StockDataEntity) obj;
		return Objects.equals(date, other.date) && Objects.equals(stock, other.stock);
	}

	@Override
	public String toString() {
		return "StockDataEntity [quarter=" + quarter + ", stock=" + stock + ", date=" + date + ", open=" + open
				+ ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume
				+ ", percentChangePrice=" + percentChangePrice + ", percentChangeVolumeOveLastWeek="
				+ percentChangeVolumeOverLastWk + ", previousWeeksVolume=" + previousWeeksVolume + ", nextWeeksOpen="
				+ nextWeeksOpen + ", nextWeeksClose=" + nextWeeksClose + ", percentChangeNextWeeksPrice="
				+ percentChangeNextWeeksPrice + ", daysToNextDividend=" + daysToNextDividend
				+ ", percentReturnNextDividend=" + percentReturnNextDividend + "]";
	}
}