//package org.scau.mall.service;
//
//import java.util.List;
//
//import org.scau.mall.dao.PmsClientLoanRecordDao;
//import org.scau.mall.pojo.PmsClientLoanRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
///**
// * PmsClientLoadRecord服务类
// * @Description: 
// * @author: zhouguangming
// * @date: 2020年7月8日 下午7:05:24
// * @version: V1.0
// * @Copyright: xrk
// */
//@Service
//public class PmsClientLoadRecordService {
//	
//	@Autowired
//	private PmsClientLoanRecordDao pmsClientLoanRecordDao;
//	
//	/**
//	 * 根据id查询并缓存
//	 * value表示缓存空间，表示查询pmsClient:query空间的key及value
//	 * keyGenerator表示key的生成器，需要重写keyGenerator类
//	 * simpleKey以传入参数作为key
//	 * @Description: 
//	 * @author: zhouguangming
//	 * @date: 2020年7月8日 下午10:28:24
//	 */
//	@Cacheable(value="pmsClientLoadRecord:query", keyGenerator = "simpleKey")
//	public PmsClientLoanRecord findById(Integer id) {
//		return pmsClientLoanRecordDao.getOne(id);
//	}
//	
//	/**
//	 * 创建方法
//	 * @CachePut表示修改缓存，没有则创建
//	 * value表示缓存空间，表示查询pmsClient:operate空间的key及value
//	 * objectId是实体类ID
//	 * @Description: 
//	 * @author: zhouguangming
//	 * @date: 2020年7月8日 下午10:31:26
//	 */
//	@CachePut(value="pmsClientLoanRecord:operate", keyGenerator = "objectId")
//	public PmsClientLoanRecord create(PmsClientLoanRecord PmsClient) {
//		return pmsClientLoanRecordDao.save(PmsClient);
//	}
//	
//	/**
//	 * 移除数据
//	 * @Description: 
//	 * @author: zhouguangming
//	 * @date: 2020年7月8日 下午10:34:02
//	 */
//	@CacheEvict(value="pmsClientLoanRecord:operate", keyGenerator = "simpleKey")
//	public void delete(Integer id) {
//	    pmsClientLoanRecordDao.delete(id);
//	}
//	
//	/**
//     * 分页查询所有，带排序功能
//     */
//	@SuppressWarnings("unchecked")
//	public List<PmsClientLoanRecord> findByPage(){
//		//分页+排序查询演示：
//        //Pageable pageable = new PageRequest(page, size);//2.0版本后,该方法以过时,2.0后用PageRequest.of(page, size, sort);
//        Sort sort = new Sort(Sort.Direction.DESC, "updateTime","createTime");
//        Pageable pageable = new PageRequest(1, 10, sort);
//        return (List<PmsClientLoanRecord>) pmsClientLoanRecordDao.findAll(pageable);
//	}
//	
//	/**
//     * 复杂查询
//     */
//	public List<PmsClientLoanRecord> findByExample(){
//	    PmsClientLoanRecord client = new PmsClientLoanRecord();
////		client.setName("测试");
//		// 创建实例
//	    Example<PmsClientLoanRecord> example = Example.of(client);
//	    // 查询
//	    List<PmsClientLoanRecord> clients = pmsClientLoanRecordDao.findAll(example);
//	    return clients;
//	}
//}
