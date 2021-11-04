package com.graduationproject.dao;

import com.graduationproject.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DeptDao {


    Dept queryById(Integer id);


    List<Dept> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    List<Dept> queryAll(Dept dept);

    int insert(Dept dept);


    int insertBatch(@Param("entities") List<Dept> entities);


    int insertOrUpdateBatch(@Param("entities") List<Dept> entities);


    int update(Dept dept);


    int deleteById(Integer id);

}

