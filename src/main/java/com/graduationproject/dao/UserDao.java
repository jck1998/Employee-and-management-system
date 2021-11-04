package com.graduationproject.dao;

import com.graduationproject.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper//用来创建DAO对象
public interface UserDao {
  void save (User user);

  User findRepeatName(String username);
}
