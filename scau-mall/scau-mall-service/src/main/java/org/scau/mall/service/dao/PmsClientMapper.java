package org.scau.mall.service.dao;

import java.util.List;

import javax.websocket.server.PathParam;

import org.scau.mall.service.pojo.PmsClient;
import org.scau.mall.service.pojo.PmsClientExample;

public interface PmsClientMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    long countByExample(PmsClientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int deleteByExample(PmsClientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int insert(PmsClient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int insertSelective(PmsClient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    List<PmsClient> selectByExample(PmsClientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    PmsClient selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@PathParam("record") PmsClient record, @PathParam("example") PmsClientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int updateByExample(@PathParam("record") PmsClient record, @PathParam("example") PmsClientExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PmsClient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_client
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PmsClient record);
}