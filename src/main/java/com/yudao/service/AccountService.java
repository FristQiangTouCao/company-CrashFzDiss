//package com.yudao.service;
//
//import com.yudao.controller.dto.AccountSearchDTO;
//import com.yudao.entity.Account;
//import com.yudao.po.*;
//
//import java.util.List;
//
///**
// * @function:
// * @author: lijun
// * @address: 杭州市 江干区 万达商业中心 1019
// * @date: 2019/9/2
// * @version:
// */
//public interface AccountService {
//
////    /**
////     * 根据类型和条数  查询出对应的账号的信息
////     * @param type
////     * @param number
////     * @return
////     */
////    List<Account> getAccountByTypeAndNumber(Integer type,Integer number);
//
//    /**
//     * 根据查询的条件获得账号列表
//     * @param accountSearchDTO
//     * @return
//     */
//    List<Account> getAccountBySearchKey(AccountSearchDTO accountSearchDTO);
//
//
//    /**
//     * 删除失效的账号
//     */
//    void deleteUselessAccount();
//
//    Integer getCount(AccountSearchDTO accountSearchDTO);
//
//    void updateAccountState(String phone,Integer type,Integer state);
//
//    /**
//     * 保存账号
//     * @param account
//     */
//    void saveAccount(Account account);
//
//
//    Account getAccountByPhoneAndType(String phone, Integer type);
//
//    /**
//     * 根据账号的状态进行切换
//     * @param id
//     * @return
//     */
//    int switchStatus(Integer id);
//
//    /**
//     * 更新快手账号中豆的个数
//     * @param phone
//     * @param dou
//     */
//    void updateDou(String phone,Integer dou);
//
//    /**
//     * 更新账号信息
//     * @param account
//     */
//    void updateAccount(Account account);
//
//}
