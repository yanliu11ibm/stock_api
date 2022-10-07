package com.rbc.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.demo.exception.RecordNotFoundException;
import com.rbc.demo.message.ResponseMessage;
import com.rbc.demo.model.StockDataEntity;
import com.rbc.demo.service.StockDataService;
import com.rbc.demo.utils.CSVHelperUtil;

@RestController
@RequestMapping("/api/stock-data")
public class StockController {
	@Autowired
	StockDataService stockDataService;

	@PostMapping("/bulk-insert")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			List<StockDataEntity> stockDataList = CSVHelperUtil.csvToStockData(file.getInputStream());

			stockDataService.save(stockDataList);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
		}
	}

	@GetMapping("/{stock}")
	public ResponseEntity<List<StockDataEntity>> getStockData(@PathVariable("stock") String stock)
			throws RecordNotFoundException {
		return new ResponseEntity<List<StockDataEntity>>(stockDataService.getStockByStockName(stock), new HttpHeaders(),
				HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseMessage> saveStock(@RequestBody StockDataEntity stockData) {
		System.out.println(stockData);
		try {
			stockDataService.save(stockData);

			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("saved stock successfully: "));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseMessage("Could not save the stock data!"));
		}
	}
}