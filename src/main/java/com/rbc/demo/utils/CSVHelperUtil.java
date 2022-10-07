package com.rbc.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import com.rbc.demo.model.StockDataEntity;

public class CSVHelperUtil {
	/**
	 * Convert the csv file content to a list of stock data.
	 * 
	 * @param is the input stream.
	 * @return list of stock data.
	 */
	public static List<StockDataEntity> csvToStockData(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			return csvParser.getRecords().stream().map(r -> convertToStockDataEntity(r)).collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	/**
	 * Convert CSV record to stock data object.
	 * 
	 * @param record the csv record.
	 * @return the stock data object.
	 */
	private static StockDataEntity convertToStockDataEntity(CSVRecord record) {
		StockDataEntity stockDataEntity = new StockDataEntity();

		stockDataEntity.setQuarter(record.get("quarter"));
		stockDataEntity.setStock(record.get("stock"));
		stockDataEntity.setDate(record.get("date"));
		stockDataEntity.setOpen(record.get("open"));
		stockDataEntity.setHigh(record.get("high"));
		stockDataEntity.setLow(record.get("low"));
		stockDataEntity.setClose(record.get("close"));
		stockDataEntity
				.setVolume(!StringUtils.isBlank(record.get("volume")) ? Long.parseLong(record.get("volume")) : null);
		stockDataEntity.setPercentChangePrice(!StringUtils.isBlank(record.get("percent_change_price"))
				? Double.parseDouble(record.get("percent_change_price"))
				: null);
		stockDataEntity.setPercentChangeVolumeOverLastWk(
				!StringUtils.isBlank(record.get("percent_change_volume_over_last_wk"))
						? Double.parseDouble(record.get("percent_change_volume_over_last_wk"))
						: null);
		stockDataEntity.setPreviousWeeksVolume(!StringUtils.isBlank(record.get("previous_weeks_volume"))
				? Long.parseLong(record.get("previous_weeks_volume"))
				: null);
		stockDataEntity.setNextWeeksOpen(record.get("next_weeks_open"));
		stockDataEntity.setNextWeeksClose(record.get("next_weeks_close"));
		stockDataEntity
				.setPercentChangeNextWeeksPrice(!StringUtils.isBlank(record.get("percent_change_next_weeks_price"))
						? Double.parseDouble(record.get("percent_change_next_weeks_price"))
						: null);
		stockDataEntity.setDaysToNextDividend(!StringUtils.isBlank(record.get("days_to_next_dividend"))
				? Integer.parseInt(record.get("days_to_next_dividend"))
				: null);
		stockDataEntity.setPercentReturnNextDividend(!StringUtils.isBlank(record.get("percent_return_next_dividend"))
				? Double.parseDouble(record.get("percent_return_next_dividend"))
				: null);

		return stockDataEntity;
	}
}
