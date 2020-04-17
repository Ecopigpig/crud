package com.examination.crud.service.Impl;

import com.examination.crud.dao.UserMapper;
import com.examination.crud.model.UserInfo;
import com.examination.crud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public Map<Long,String> getAllUserEmail(Set<Long> userIdList) {
        Map<Long, UserInfo> map;
        map =  userMapper.selectAllUserEmail(userIdList);
        Map<Long,String> resultMap = new HashMap<>();
        for(Long id :map.keySet()){
            UserInfo userInfo = map.get(id);
            resultMap.put(userInfo.getId(),userInfo.getEmail());
        }
        return resultMap;
    }

    @Override
    public UserInfo getUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public UserInfo confirmUser(UserInfo userInfo) {
        return userMapper.confirmUser(userInfo);
    }

    @Override
    public int insertToken(Long userId, String token) {
        return userMapper.updateToken(userId,token);
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public int addNewUser(UserInfo param) {
        return userMapper.insertNewUser(param);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userMapper.updateUserInfo(userInfo);
    }

    @Override
    public void changeUserStatus(Byte status,Long userId) {
        userMapper.changeUserStatus(status,userId);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public UserInfo findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public UserInfo findUserById(Long userId) {
        return userMapper.findUserById(userId);
    }
}
