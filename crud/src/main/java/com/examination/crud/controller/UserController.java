package com.examination.crud.controller;

import com.examination.crud.model.PageParam;
import com.examination.crud.model.ResponseResult;
import com.examination.crud.model.UserInfo;
import com.examination.crud.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registerAccount", method = RequestMethod.POST)
    public ResponseResult registerAccount(@RequestParam("username")String name) {
        ResponseResult result = new ResponseResult();
        result.setMsg(false);
        //用户名不可重复
        if(name.isEmpty()){
            return result;
        }else{
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(name);
            int i = userService.addNewUser(userInfo);
            if(i>0){
                result.setMsg(true);
            }
        }
        return result;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ResponseResult deleteUser(@RequestParam("id")Long id) {
        ResponseResult result = new ResponseResult();
        result.setMsg(false);
        //用户名不可重复
        if(id==null){
            return result;
        }else{
            userService.deleteById(id);
            result.setMsg(true);
        }
        return result;
    }

    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public ResponseResult findUser(@RequestParam("username")String username) {
        ResponseResult result = new ResponseResult();
        result.setMsg(false);
        UserInfo userInfo = userService.findUserByName(username);
        if(userInfo!=null){
            result.setMsg(true);
            result.setData(userInfo);
        }
        return result;
    }


    @RequestMapping(value = "/listAllUsers", method = RequestMethod.POST)
    public ResponseResult listAllUsers(@RequestBody PageParam pageParam) {
        ResponseResult result = new ResponseResult();
        result.setMsg(false);
        int pageIndex = pageParam.getPage()<=0?1:pageParam.getPage();
        int pageSize = pageParam.getSize()<=0?20:pageParam.getSize();
        PageHelper.startPage(pageIndex,pageSize);
        List<UserInfo> userInfoList = userService.getAllUsers();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        if(pageInfo.getSize()>0){
            result.setMsg(true);
            result.setData(pageInfo);
        }
        return result;
    }

    @RequestMapping(value = "/changeUserStatus",method = RequestMethod.POST)
    public ResponseResult changeUserStatus(@RequestParam("userId")Long userId){
        ResponseResult result = new ResponseResult();
        UserInfo userInfo = userService.findUserById(userId);
        Byte disable = 1,enabled = 0;
        if(userInfo.getStatus().equals(disable)){
            userService.changeUserStatus(enabled,userId);
        }else{
            userService.changeUserStatus(disable,userId);
        }
        result.setMsg(true);
        return result;
    }

}
