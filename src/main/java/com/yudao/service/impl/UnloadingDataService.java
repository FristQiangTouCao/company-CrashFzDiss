package com.yudao.service.impl;

import com.yudao.dao.sql.TaobaoPhone1Mapper;
import com.yudao.entity.FzDiss;
import com.yudao.entity.TaobaoPhone1;
import com.yudao.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author weed
 * @Address 江干区 迈达商业中心
 * @Date 2020/1/15 0015 10:14
 * @Version
 */
@Component
public class UnloadingDataService {

    @Autowired
    private TaobaoPhone1Mapper taobaoPhone1Mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    private int count = 1;

    @Value("${customer.page:0}")
    private int page;

    @PostConstruct
    public void unloadingFeiZuData() {

        int rows = 10;
        long startTime = System.currentTimeMillis();
        while(true) {
            try{
                List<FzDiss> fzDissList = getFzDissList(page * rows, rows);
                if(!CollectionUtils.isEmpty(fzDissList)) {
                    fzDissList.forEach(fzDiss -> {
                        if (findDissByUserId(fzDiss.getUserId())) {
                            String phone = getPhone(fzDiss.getUserId());
                            if(phone != null) {
                                fzDiss.setPhone(phone);
                                saveData(fzDiss);
                            }
                        }
                    });
                    page ++;
                    System.err.println("update data count:" + page*rows);
                }else {
                    System.err.println("全部数据加载结束，耗时："+(System.currentTimeMillis() - startTime)/1000/60+"分钟");
                    break;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 在mongo里面分页获取diss的列表
     * @param start
     * @param rows
     * @return
     */
    public List<FzDiss> getFzDissList(int start, int rows) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("userId").exists(true)),
                Aggregation.match(Criteria.where("userId").ne("")),
                Aggregation.skip(start),
                Aggregation.limit(rows)
        );
        AggregationResults<FzDiss> aggregate = mongoTemplate.aggregate(aggregation, Constant.MCN_FZ_DISS, FzDiss.class);
        return aggregate.getMappedResults();
    }

    /**
     * 在mysql中通过userid获取电话号
     * @param userId
     * @return
     */
    public String getPhone(String userId) {
        List<String> phone = taobaoPhone1Mapper.getInfoByUserId(userId);
        if(!CollectionUtils.isEmpty(phone)) {
            return phone.get(0);
        }
        return null;
    }

    /**
     * 保存数据到mongo中
     * @param fzDiss
     */
    public void saveData(FzDiss fzDiss) {
        mongoTemplate.insert(fzDiss,Constant.MCN_FZ_DISS_SELECTED);
        System.err.println(count++ + "-insert a data:"+fzDiss);
    }

    /**
     * 通过userid在mongo中判断数据库中是否有该用户的数据
     * @param userId
     * @return
     */
    public boolean findDissByUserId(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        List<Map> maps = mongoTemplate.find(query, Map.class, Constant.MCN_FZ_DISS_SELECTED);
        if(!CollectionUtils.isEmpty(maps)) {
            System.err.println("repetition data skip。 userId:"+userId);
            return false;
        }
        return true;
    }
}
