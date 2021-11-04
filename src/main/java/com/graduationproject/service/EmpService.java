package com.graduationproject.service;

import com.graduationproject.entity.Emp;

import java.util.List;

public interface EmpService {

  List<Emp> find(String deptId);

  void save(Emp emp);

  void delete(String id);

  Emp findHead(String id);

  void update(Emp emp);

}
