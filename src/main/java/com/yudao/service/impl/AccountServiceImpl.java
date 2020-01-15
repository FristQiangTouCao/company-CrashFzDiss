//package com.yudao.service.impl;
//
//import com.mongodb.QueryBuilder;
//import com.yudao.controller.dto.AccountSearchDTO;
//import com.yudao.dao.sql.AccountMapper;
//import com.yudao.entity.Account;
//import com.yudao.entity.AccountExample;
//import com.yudao.po.*;
//import com.yudao.service.AccountService;
//import com.yudao.util.DeleteFileUtil;
//import com.yudao.util.ResponseUtil;
//import org.apache.ibatis.javassist.runtime.Desc;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.BasicQuery;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Order;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
///**
// * @function:
// * @author: lijun
// * @address: 杭州市 江干区 万达商业中心 1019
// * @date: 2019/9/2
// * @version:
// */
//@Service
//public class AccountServiceImpl implements AccountService {
//
//    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);
//    @Autowired
//    private AccountMapper accountMapper;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//
////    @Override
////    public List<Account> getAccountByTypeAndNumber(Integer type, Integer number) {
////        List<Account> list = accountMapper.getAccountByTypeAndNumber(type,number);
////        return list;
////    }
//
//    @Override
//    public List<Account> getAccountBySearchKey(AccountSearchDTO accountSearchDTO) {
//        Integer page = accountSearchDTO.getPage() == 0? 1:accountSearchDTO.getPage();
//        Integer rows = accountSearchDTO.getRows();
//        Integer type = accountSearchDTO.getType();
//        String account = accountSearchDTO.getAccount();
//        Integer platformId = accountSearchDTO.getPlatformId();
//        String instanceName = accountSearchDTO.getInstanceName();
//        Integer state = accountSearchDTO.getState();
//        Integer ismy = accountSearchDTO.getIsmy();
//        return accountMapper.getAccountBySearchKey((page-1)*rows,rows,type,account,platformId,instanceName, state, ismy);
//    }
//
//    @Override
//    public void deleteUselessAccount() {
//        AccountExample accountExample = new AccountExample();
//        AccountExample.Criteria criteria = accountExample.createCriteria();
//        criteria.andStateEqualTo(new Byte("0"));
//        accountMapper.deleteByExample(accountExample);
//    }
//
//    @Override
//    public Integer getCount(AccountSearchDTO accountSearchDTO) {
//        return accountMapper.getCount(accountSearchDTO.getType(),accountSearchDTO.getAccount(),accountSearchDTO.getPlatformId(),accountSearchDTO.getInstanceName(),accountSearchDTO.getState(),accountSearchDTO.getIsmy());
//    }
//
//    @Override
//    public void updateAccountState(String phone, Integer type, Integer state) {
//        accountMapper.updateAccountState(phone,type,state);
//    }
//
//    @Override
//    public void saveAccount(Account account1) {
//
//        Account account = getAccountByPhoneAndType(account1.getPhone(), new Integer(account1.getType()));
//        if(account!= null){
//            account.setTime(new Date());
//            account.setBackupUrl(account1.getBackupUrl());
//            account.setNick(account1.getNick());
//            account.setMd5(account1.getMd5());
//            account.setKuaiId(account1.getKuaiId());
//            AccountExample accountExample = new AccountExample();
//            accountMapper.updateByPrimaryKeySelective(account);
//        } else {
//            Account accountDTO = new Account();
//            accountDTO.setBackupUrl(account1.getBackupUrl());
//            accountDTO.setPhone(account1.getPhone());
//            accountDTO.setType(account1.getType());
//            accountDTO.setTime(new Date());
//            accountDTO.setState(new Byte("1"));
//            accountDTO.setNick(account1.getNick());
//            accountDTO.setMd5(account1.getMd5());
//            accountDTO.setPlatformId(account1.getPlatformId());
//            accountDTO.setKuaiId(account1.getKuaiId());
//            accountMapper.insert(accountDTO);
//        }
//    }
//
//
//    @Override
//    public Account getAccountByPhoneAndType(String phone, Integer type) {
//        AccountExample accountExample = new AccountExample();
//        AccountExample.Criteria criteria = accountExample.createCriteria();
//        criteria.andPhoneEqualTo(phone);
//        criteria.andTypeEqualTo(type.byteValue());
//        List<Account> accounts = accountMapper.selectByExample(accountExample);
//        if(accounts != null && accounts.size()>0){
//            return accounts.get(0);
//        }
//        return null;
//    }
//
//
//    @Override
//    public int switchStatus(Integer id) {
//        Account account = accountMapper.selectByPrimaryKey(id);
//        if(account != null){
//            try{
//                if(account.getState() != null){
//                    account.setState(account.getState() == 1?new Byte("0"):new Byte("1"));
//                    return accountMapper.updateByPrimaryKeySelective(account) ;
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return 0;
//    }
//
//    @Override
//    public void updateDou(String phone, Integer dou) {
//        accountMapper.updateDou(phone,dou);
//    }
//
//    @Override
//    public void updateAccount(Account account) {
//        Account accountNew = new Account();
//        accountNew.setId(account.getId());
//        accountNew.setInstanceName(account.getInstanceName());
//        accountNew.setIsmy(account.getIsmy());
//        accountMapper.updateByPrimaryKeySelective(accountNew);
//    }
//
//
//
//
//
//
//}
