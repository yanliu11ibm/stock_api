package com.rbc.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.rbc.demo.exception.RecordNotFoundException;
import com.rbc.demo.model.StockDataEntity;
import com.rbc.demo.repository.StockDataRepository;

@Service
public class StockDataServiceImpl implements StockDataService {
	@Autowired
	StockDataRepository stockDataRepository;

	@Override
	public void save(List<StockDataEntity> stockDataList) throws IOException {
		stockDataRepository.saveAll(stockDataList);
	}

	@Override
	public List<StockDataEntity> getStockByStockName(String stock) throws RecordNotFoundException {
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withMatcher("stock",
				ExampleMatcher.GenericPropertyMatchers.exact());

		StockDataEntity example = new StockDataEntity();
		example.setStock(stock);

		return stockDataRepository.findAll(Example.of(example, matcher));
	}

	@Override
	public List<StockDataEntity> getAllStocks() {
		return stockDataRepository.findAll();
	}

	@Override
	public void save(StockDataEntity stockData) throws IOException {
		stockDataRepository.save(stockData);	
	};
}