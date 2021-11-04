package com.graduationproject.service;

import com.graduationproject.dao.DeptDao;
import com.graduationproject.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;


    @Override
    public Dept queryById(Integer id) {
        return this.deptDao.queryById(id);
    }


    @Override
    public List<Dept> queryAllByLimit(int offset, int limit) {
        return this.deptDao.queryAllByLimit(offset, limit);
    }

    @Override
    public Dept insert(Dept dept) {
        dept.setCreatedat(new Date());
        this.deptDao.insert(dept);
        return dept;
    }


    @Override
    public Dept update(Dept dept) {
        this.deptDao.update(dept);
        return this.queryById(dept.getId());
    }


    @Override
    public boolean deleteById(Integer id) {
        return this.deptDao.deleteById(id) > 0;
    }
}
