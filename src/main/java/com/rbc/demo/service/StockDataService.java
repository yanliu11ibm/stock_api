package com.rbc.demo.service;

import java.io.IOException;
import java.util.List;

import com.rbc.demo.exception.RecordNotFoundException;
import com.rbc.demo.model.StockDataEntity;

public interface StockDataService {
	/**
	 * Save a list of stock data.
	 * 
	 * @param stockDataList the stock data list.
	 * @throws IOException throws IOException if there is.
	 */
	public void save(List<StockDataEntity> stockDataList) throws IOException;

	/**
	 * Get list of stock using the stock name.
	 * 
	 * @param stock the stock name.
	 * @return list of stock
	 * @throws RecordNotFoundException throws RecordNotFoundException if there is.
	 */
	public List<StockDataEntity> getStockByStockName(String stock) throws RecordNotFoundException;

	/**
	 * Get all the stocks.
	 * 
	 * @return All the stocks.
	 */
	public List<StockDataEntity> getAllStocks();

	/**
	 * Save stock data.
	 * 
	 * @param stockData the stock data.
	 * @throws IOException throws IOException if there is.
	 */
	public void save(StockDataEntity stockData) throws IOException;
}
