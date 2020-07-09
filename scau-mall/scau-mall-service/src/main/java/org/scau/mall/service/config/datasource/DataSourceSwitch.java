package org.scau.mall.service.config.datasource;
import java.util.Stack;

import org.springframework.util.StringUtils;

/**
 * 数据类型切换类
 * @author John
 *
 */

public class DataSourceSwitch {
	
	private static ThreadLocal<Stack<DataSourceType>> contextHolder = new ThreadLocal<Stack<DataSourceType>>();
	
	public static void setDbType(DataSourceType dbType) {
		Stack<DataSourceType> stack = getStack();
		if(stack == null) {
			stack = new Stack<DataSourceType>();
		}
		stack.push(dbType);
		contextHolder.set(stack);
	}

	private static Stack<DataSourceType> getStack() {
		return contextHolder.get();
	}
	
	/**
	 * 获取当前线程dbType
	 * @return
	 */
	public static String getDbType() {
		Stack<DataSourceType> stack = getStack();
		if(stack != null && !stack.isEmpty()) {
			DataSourceType dbType = stack.firstElement();
			if(dbType != null) {
				return dbType.getDataSource();
			}
			return null;
		}
		return null;
	}
	
	/**
	 * 移除DbType标记
	 * @return
	 */
	public static DataSourceType popDbType() {
		Stack<DataSourceType> stack = getStack();
		if(!StringUtils.isEmpty(stack)) {
			DataSourceType dbType = stack.pop();
			if(stack.isEmpty()) {
				clearDbType();
			}
			return dbType;
		}
		return null;
	}

	/**
	 * 清除ThreadLocal变量
	 */
	public static void clearDbType() {
		contextHolder.remove(); 
	}
}
