package com.graduationproject.service;


import com.graduationproject.entity.Dept;

import java.util.List;


public interface DeptService {

    Dept queryById(Integer id);

    List<Dept> queryAllByLimit(int offset, int limit);

    Dept insert(Dept dept);

    Dept update(Dept dept);

    boolean deleteById(Integer id);

}
