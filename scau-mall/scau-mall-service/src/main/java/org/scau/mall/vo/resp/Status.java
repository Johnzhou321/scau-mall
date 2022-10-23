package org.scau.mall.vo.resp;


/**
 * 状态码通用接口
 * @author ZH
 * @version 1.0
 * @date 2015年10月19日下午12:50:17
 * @copyright xiangrikui
 */
public interface Status {
	
	/**
	 * 获取状态码
	 * @return
	 */
	public Integer getStatus();
	
	/**获取状态消息
	 * @return
	 */
	public String getStatusMsg();
	
	

}
