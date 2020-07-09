package org.scau.mall.service.jpa;

import java.io.Serializable;

import org.scau.mall.service.pojo.PmsClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 公用抽象jpa类
 * @Description: JpaRepository已继承了分页PagingAndSortingRepository及复杂查询类QueryByExampleExecutor
 * @author: zhouguangming
 * @date: 2020年7月8日 下午6:04:57
 * @version: V1.0
 * @param <T>
 * @Copyright: xrk
 */
public interface MyJpaRepository<T> extends JpaRepository<T, Serializable>{
	
}
