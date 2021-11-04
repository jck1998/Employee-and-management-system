package com.graduationproject.service;


import com.graduationproject.dao.UserDao;
import com.graduationproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional

public class UserServiceImpl implements UserService{

  @Autowired
  private UserDao userDao;

  @Override
  public void register(User user) {
    //0.根据用户输入用户名判断用户是否存在
    User userDB = userDao.findRepeatName(user.getUsername());
    if (userDB==null){
      //1.生成用户状态
      user.setStatus("已激活");
      //2.设置用户注册时间
      user.setRegisterTime(new Date());
      //3.调用DAO
      userDao.save(user);
    }else{
      throw new RuntimeException("用户名已存在");
    }
  }

  @Override
  public User login(User user) {
    //1.根据用户输入用户名进行查询
    User repeatName = userDao.findRepeatName(user.getUsername());
    if (repeatName!=null){
      //2.比较密码
      if (repeatName.getPassword().equals(user.getPassword())) {
        return repeatName;
      }else {
        throw new RuntimeException("密码错误");
      }
    }else {
      throw new RuntimeException("用户名错误");
    }
  }
}
