package org.scau.mall.web.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.scau.mall.dao.PmsClientMapper;
import org.scau.mall.dao.extend.OrdersMapper;
import org.scau.mall.pojo.PmsClient;
import org.scau.mall.pojo.PmsClientExample;
import org.scau.mall.pojo.PmsClientExample.Criteria;
import org.scau.mall.service.pojo.PmsOrders;
import org.scau.mall.utils.CommonUtil;
import org.scau.mall.vo.ClientLoadRecordVo;
import org.scau.mall.vo.PageVo;
import org.scau.mall.vo.Pagination;
import org.scau.mall.vo.PmsClientQueryVo;
import org.scau.mall.vo.PmsClientShowVo;
import org.scau.mall.vo.resp.ResponeData;
import org.scau.mall.web.enums.LoanStatus;
import org.scau.mall.web.vo.ApproveFormBody;
import org.scau.mall.web.vo.AuditFormBody;
import org.scau.mall.web.vo.OrdersVo;
import org.scau.mall.web.vo.PageShowVo;
import org.scau.mall.web.vo.QueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrderServiceImpl {
    
    @Autowired
    private OrdersMapper ordersMapper;
    
    @Autowired
    private PmsClientMapper PmsClientMapper;
    
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    
    @Transactional
    public ResponeData<Object> submitClientLoadRecord(ClientLoadRecordVo body) {
        logger.info("submitClientLoadRecord param body={}", body);
        PmsClient client = savePmsClient(body);
        savePmsClientLoanRecord(body, client.getId());
        
        return ResponeData.success();
        
    }
    
    @Transactional
    public PmsClient savePmsClient(ClientLoadRecordVo body) {
        //先查看该客户是否已经存在，如果已经存在则直接返回
        PmsClient client = getClinetByIdNumber(body.getId_number());
        if(client != null) {
         return client;   
        }
        client = new PmsClient();
        client.setName(body.getName());
        client.setIdNumber(body.getId_number());
        client.setTelephone(body.getTelephone());
        client.setStatus(1);
        client.setCreatedAt(new Date());
        PmsClientMapper.insert(client);
        return client;
    }
    
    public PmsClient getClinetByIdNumber(String idNumber) {
        PmsClientExample example = new PmsClientExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdNumberEqualTo(idNumber);
        List<PmsClient> list = PmsClientMapper.selectByExample(example);
        PmsClient client = null;
        if(list.size() > 0) {
            client = list.get(0);
        }
        return client;
    }
    
    @Transactional
    public PmsOrders savePmsClientLoanRecord(ClientLoadRecordVo body, int clientId) {
        PmsOrders record = new PmsOrders();
        record.setOrderNo(CommonUtil.newUnusedOrderNo());
        record.setClientId(clientId);
        record.setApplyAmount(new BigDecimal(body.getAmount()));
        record.setType(body.getQualification());
        record.setStatus(0);
        record.setCreatedAt(new Date());
        ordersMapper.insert(record);
        return record;
    }
    
    public Pagination<PmsClientShowVo> getPaginationPmsClientLoanRecordList(PmsClientQueryVo vo) {
        Pagination<PmsClientShowVo> pg = new Pagination<>();
        int total = ordersMapper.countPmsOrdersList(vo);
        List<PmsClientShowVo> voList = ordersMapper.getPaginationPmsOrdersList(vo);
        PageVo meta = new PageVo();
        meta.setTotal(total);
        meta.setPage(vo.getPage());
        meta.setPerPage(vo.getLimit());
        meta.setTotalPage((total + vo.getLimit() - 1) / vo.getLimit());
        pg.setMeta(meta);
        pg.setList(voList);
        return pg;
    }
    
    /**
     * 分页获取订单列表
            * @param vo
            * @return
     */
    public PageShowVo<OrdersVo> getOrdersByPage(QueryVo vo){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", vo.getQuery());//先只查客户姓名
        int total = ordersMapper.countPmsOrders(params);
        params.put("limit", vo.getPagesize());
        params.put("offSet", vo.getOffSet());
        List<Map<String, Object>> list = ordersMapper.getPmsOrdersList(params);
        PageShowVo<OrdersVo> showVo = new PageShowVo<OrdersVo>();
        List<OrdersVo> ordervos = new ArrayList<OrdersVo>();
        list.forEach(order ->{
            OrdersVo ordersvo = new OrdersVo();
            ordersvo.setOrderNo(covertObjToStr(order.get("order_no")));
            ordersvo.setName(covertObjToStr(order.get("name")));
            ordersvo.setIdNumber(covertObjToStr(order.get("id_number")));
            ordersvo.setType(covertObjToStr(order.get("type")));
            ordersvo.setAmount(covertObjToStr(order.get("apply_amount")));
            ordersvo.setActualAmount(covertObjToStr(order.get("actual_amount")));
            ordersvo.setDocumentUrl(covertObjToStr(order.get("document_url")));
            ordersvo.setClientId(Integer.parseInt(covertObjToStr(order.get("client_id"))));
            ordersvo.setStatus(LoanStatus.getDescByCode(covertObjToStr(order.get("status"))));
            ordersvo.setCreatedAt(covertObjToStr(order.get("created_at")));//DateUtil.getFormatDate(DateUtil.DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS, String.valueOf(order.get("id")))
            ordersvo.setAuditTime(covertObjToStr(order.get("audit_time")));//DateUtil.getFormatDate(DateUtil.DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS, String.valueOf(order.get("id")))
            ordersvo.setApproveTime(covertObjToStr(order.get("approve_time")));//DateUtil.getFormatDate(DateUtil.DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS, String.valueOf(order.get("id")))
            ordervos.add(ordersvo);
        });
        showVo.setTotal(total);
        showVo.setPagenum(vo.getPagenum());
        showVo.setList(ordervos);
        return showVo;
    }
    
    /**
     * 审核
    		* @param body
    		* @throws Exception
     */
    @Transactional
    public void verifyPass(AuditFormBody body) throws Exception{
        //更新订单状态
        PmsOrders orders = new PmsOrders();
        orders.setOrderNo(body.getOrderNo());
        orders.setStatus(Integer.valueOf(body.getAuditResult()));
        orders.setAuditRemark(body.getRemarks());
        orders.setAuditTime(new Date());
        orders.setUpdatedAt(new Date());
        orders.setDocumentUrl(body.getUploadPath());
        ordersMapper.updateByPrimaryKeySelective(orders);
    }
    
    /**
     * 放款
    		* @param body
    		* @throws Exception
     */
    @Transactional
    public void approveSubmit(ApproveFormBody body) throws Exception{
        //更新订单状态
        PmsOrders orders = new PmsOrders();
        orders.setOrderNo(body.getOrderNo());
        orders.setActualAmount(new BigDecimal(body.getActualAmount()));
        orders.setStatus(3);
        orders.setApproveTime(new Date());
        orders.setUpdatedAt(new Date());
        ordersMapper.updateByPrimaryKeySelective(orders);
    }
    
    public String covertObjToStr(Object obj) {
        if(obj == null) {
            return null;
        }
        return obj.toString();
    }
}
