package org.scau.mall.dao;

import java.util.List;

import org.scau.mall.pojo.PmsClientLoanRecord;
import org.scau.mall.pojo.PmsClientLoanRecordExample;
import org.springframework.data.repository.query.Param;

public interface PmsClientLoanRecordMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    long countByExample(PmsClientLoanRecordExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int deleteByExample(PmsClientLoanRecordExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int insert(PmsClientLoanRecord record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int insertSelective(PmsClientLoanRecord record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    List<PmsClientLoanRecord> selectByExample(PmsClientLoanRecordExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    PmsClientLoanRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PmsClientLoanRecord record, @Param("example") PmsClientLoanRecordExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int updateByExample(@Param("record") PmsClientLoanRecord record, @Param("example") PmsClientLoanRecordExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PmsClientLoanRecord record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table pms_client_loan_record
     * @mbg.generated
     */
    int updateByPrimaryKey(PmsClientLoanRecord record);
}