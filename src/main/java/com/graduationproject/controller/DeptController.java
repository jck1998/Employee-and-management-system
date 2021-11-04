package com.graduationproject.controller;

import com.graduationproject.entity.Dept;
import com.graduationproject.entity.Emp;
import com.graduationproject.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("dept")
@CrossOrigin
@Slf4j
public class DeptController {

    @Autowired
    private DeptService deptService;



    //修改部门信息
    @PostMapping("update")
    public Map<String,Object> update(Dept dept) throws IOException {
        log.info("部门信息:[{}]",dept.toString());
        Map<String, Object> map = new HashMap<>();

        try {
            deptService.update(dept);
            map.put("state",true);
            map.put("message","部门信息保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("message","部门信息保存失败");
        }
        return map;
    }
    @GetMapping("findHead")
    public Dept findHead(Integer id){
        log.info("查询部门信息的id:[{}]",id);
        return deptService.queryById(id);
    }

    //保存部门信息
    @PostMapping("save")
    public Map<String,Object> save(Dept dept) throws IOException {
        log.info("部门信息:[{}]",dept.getName());
        Map<String, Object> map = new HashMap<>();
        try {
            deptService.insert(dept);
            map.put("state",true);
            map.put("message","部门信息保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("message","部门信息保存失败");
        }
        return map;
    }


    //删除部门信息
    @GetMapping("delete")
    public Map<String,Object> delete (String id){
        log.info("删除部门的id:[{}]",id);
        Map<String, Object> map = new HashMap<>();
        try {
            deptService.deleteById(Integer.valueOf(id));
            map.put("state",true);
            map.put("message","删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("message","删除信息失败");
        }
        return map;
    }


    @GetMapping("find")
    private List<Dept> find(){
        return deptService.queryAllByLimit(0,Integer.MAX_VALUE);
    }

}
