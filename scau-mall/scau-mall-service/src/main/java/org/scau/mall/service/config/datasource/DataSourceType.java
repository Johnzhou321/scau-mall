package org.scau.mall.service.config.datasource;

public enum DataSourceType {

    DB_MASTER("db_master"),
    DB_SLAVE("db_slave"),

    DB_WRITE("db_master"),
    DB_READ("db_read");

    private final String dataSource;

    private DataSourceType(String datasource) {
        this.dataSource = datasource;
    }

    public String getDataSource() {
        return dataSource;
    }
    
    public static DataSourceType valueOfDataSource(String dataSource) {
    	for(DataSourceType type : DataSourceType.values()){
    		if(type.getDataSource().equals(dataSource)){
    			return type;
    		}
    	}
    	return null;
    }
}