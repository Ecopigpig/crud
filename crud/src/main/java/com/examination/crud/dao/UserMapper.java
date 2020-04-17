package com.examination.crud.dao;

import com.examination.crud.model.UserInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Mapper
public interface UserMapper {
    /**
     * 通过用户ID批量查询用户邮箱
     * @param userIdList
     * @return
     */
    @MapKey("id")
    Map<Long, UserInfo> selectAllUserEmail(@Param("list") Set<Long> userIdList);

    UserInfo selectUserById(@Param("id") Long id);

    UserInfo confirmUser(UserInfo userInfo);

    int updateToken(Long userId, String token);

    List<UserInfo> selectAllUsers();

    int insertNewUser(UserInfo param);

    int updateUserInfo(UserInfo userInfo);

    @MapKey("id")
    Map<Long, UserInfo> selectUserMapByIdList(@Param("list") List<Long> userIdList);

    void changeUserStatus(@Param("status") Byte i, @Param("userId") Long userId);

    void deleteById(@Param("id") Long id);

    UserInfo findUserByName(@Param("username")String username);

    UserInfo findUserById(@Param("userId")Long userId);
}
