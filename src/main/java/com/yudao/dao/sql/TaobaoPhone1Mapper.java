package com.yudao.dao.sql;

import com.yudao.entity.TaobaoPhone1;
import com.yudao.entity.TaobaoPhone1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface TaobaoPhone1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taobao_phone1
     *
     * @mbg.generated Wed Jan 15 10:26:38 CST 2020
     */
    long countByExample(TaobaoPhone1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table taobao_phone1
     *
     * @mbg.generated Wed Jan 15 10:26:38 CST 2020
     */
    int deleteByExample(TaobaoPhone1Example example);

    int insert(TaobaoPhone1 record);


    int insertSelective(TaobaoPhone1 record);


    List<TaobaoPhone1> selectByExample(TaobaoPhone1Example example);


    int updateByExampleSelective(@Param("record") TaobaoPhone1 record, @Param("example") TaobaoPhone1Example example);


    int updateByExample(@Param("record") TaobaoPhone1 record, @Param("example") TaobaoPhone1Example example);

    List<String> getInfoByUserId(String userId);
}