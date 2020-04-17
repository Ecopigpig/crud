package com.examination.crud.service;

import com.examination.crud.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface UserService {
    /**
     * 根据用户ID批量获取用户邮箱地址
     * @param userIdList
     * @return
     */
    Map<Long,String> getAllUserEmail(Set<Long> userIdList);

    /**
     * 根据用户id获取用户实体
     * @param userId
     * @return
     */
    UserInfo getUserById(Long userId);

    /**
     * 根据用户的登录信息确认是否存在该用户
     * @param userInfo
     * @return
     */
    UserInfo confirmUser(UserInfo userInfo);

    /**
     * 把用户申请通过的Token记录在数据库中
     * @param userId
     * @param token
     * @return
     */
    int insertToken(Long userId, String token);

    /**
     * 管理员后台展示用户列表
     * @return
     */
    List<UserInfo> getAllUsers();

    /**
     * 用户注册
     * @param param
     */
    int addNewUser(UserInfo param);

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);


    /**
     * 改变用户账号状态
     * @param status
     * @param userId
     */
    void changeUserStatus(Byte status, Long userId);

    void deleteById(Long id);

    UserInfo findUserByName(String username);

    UserInfo findUserById(Long userId);
}
