DROP TABLE IF EXISTS STOCK_DATA;
 
CREATE TABLE STOCK_DATA(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  quarter VARCHAR(50) NOT NULL,
  stock VARCHAR(250) NOT NULL,
  date VARCHAR(50) NOT NULL,
  open VARCHAR(50) DEFAULT NULL,
  high VARCHAR(50) DEFAULT NULL,
  low VARCHAR(50) DEFAULT NULL,
  close VARCHAR(50) DEFAULT NULL,
  volume INT DEFAULT NULL,
  percent_change_price DOUBLE PRECISION DEFAULT NULL,
  percent_change_volume_over_last_wk DOUBLE PRECISION DEFAULT NULL,
  previous_weeks_volume INT DEFAULT NULL,
  next_weeks_open VARCHAR(50) DEFAULT NULL,
  next_weeks_close VARCHAR(50) DEFAULT NULL,
  percent_change_next_weeks_price DOUBLE PRECISION DEFAULT NULL,
  days_to_next_dividend INT DEFAULT NULL,
  percent_return_next_dividend DOUBLE PRECISION DEFAULT NULL
);