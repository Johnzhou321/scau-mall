package org.scau.mall.service.config.datasource;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	private final static Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);
	
	@Override
	protected Object determineCurrentLookupKey() {
		String dataSource = DataSourceSwitch.getDbType();
		if(DataSourceType.DB_READ.equals(dataSource)) {
			if(new Random().nextInt(2) > 0) {
				return DataSourceType.DB_MASTER.getDataSource();
			}else {
				return DataSourceType.DB_SLAVE.getDataSource();
			}
		}
		if(null == dataSource) {
			if(logger.isDebugEnabled()){
				logger.debug("Use Default datasource : db_master");
			}
			return DataSourceType.DB_MASTER.getDataSource();
		}
		if(logger.isDebugEnabled()){
			logger.debug("DataSourceSwitch: {}", dataSource);
		}
		return dataSource;
	}

}
