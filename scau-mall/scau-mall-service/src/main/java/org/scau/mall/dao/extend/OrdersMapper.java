package org.scau.mall.dao.extend;

import java.util.List;
import java.util.Map;

import org.scau.mall.dao.PmsOrdersMapper;
import org.scau.mall.vo.PmsClientQueryVo;
import org.scau.mall.vo.PmsClientShowVo;

public interface OrdersMapper extends PmsOrdersMapper{
    
    public int countPmsOrdersList(PmsClientQueryVo vo);
    
    public List<PmsClientShowVo> getPaginationPmsOrdersList(PmsClientQueryVo vo);
    
    public int countPmsOrders(Map<String, Object> params);
    
    public List<Map<String, Object>> getPmsOrdersList(Map<String, Object> params);
   
}