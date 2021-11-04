package com.graduationproject.service;


import com.graduationproject.dao.EmpDao;
import com.graduationproject.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

  @Autowired
  private EmpDao empDao;




  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public List<Emp> find(String deptId) {
    return empDao.find(deptId);
  }

  @Override
  public void save(Emp emp) {
    empDao.save(emp);
  }

  @Override
  public void delete(String id) {
    empDao.delete(id);
  }

  @Override
  public Emp findHead(String id) {
    return empDao.findHead(id);
  }

  @Override
  public void update(Emp emp) {
    empDao.update(emp);
  }
}
