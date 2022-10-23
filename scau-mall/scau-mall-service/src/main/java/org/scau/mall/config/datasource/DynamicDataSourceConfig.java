package org.scau.mall.config.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据源配置类
 * @author John
 *
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DynamicDataSourceConfig {
	
	@Autowired
	DruidDataSourceConfig druidDataSourceConfig;
	
	@Value("${druid.slave.url:null}")
	private String slaveUrl;
	
	@Value("${druid.slave.username:null}")
	private String slaveUsername;
	
	@Value("${druid.slave.password:null}")
	private String slavePassword;
	
	/**
	 * 数据源bean配置
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object,Object> targetDataSources = new HashMap<Object,Object>();
		DataSource druidMasterDataSource = druidDataSourceConfig.targetDataSource();
		targetDataSources.put(DataSourceType.DB_MASTER.getDataSource(), druidMasterDataSource);
//		if(!"null".equals(slaveUrl)) {
//			DataSource slaveSource = druidDataSourceConfig.targetDataSource(slaveUrl, slaveUsername, slavePassword);
//			targetDataSources.put(DataSourceType.DB_SLAVE.getDataSource(), slaveSource);
//		}
		dynamicDataSource.setTargetDataSources(targetDataSources);
		dynamicDataSource.setDefaultTargetDataSource(druidMasterDataSource);
		return dynamicDataSource;
	}
	
	/**
	 * 事务管理器配置
	 * @return
	 */
	@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
