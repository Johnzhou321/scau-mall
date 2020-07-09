package org.scau.mall.service.dao;

import org.scau.mall.service.jpa.MyJpaRepository;
import org.scau.mall.service.pojo.PmsClient;
/**
 * PmsClient dao层
 * @Description: 
 * @author: zhouguangming
 * @date: 2020年7月8日 下午6:57:27
 * @version: V1.0
 * @Copyright: xrk
 */
public interface PmsClientDao extends MyJpaRepository<PmsClient>{
	/**
	 * 根据name查询实体
	 * @Description: 
	 * @author: zhouguangming
	 * @date: 2020年7月8日 下午7:02:20
	 * @version: V1.0
	 * @Copyright: xrk
	 */
	public PmsClient findByName(String name);
}
