package com.graduationproject.dao;

import com.graduationproject.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpDao {
  List<Emp> find(String deptId);

  void save(Emp emp);

  void delete(String id);

  Emp findHead(String id);

  void update(Emp emp);

}
