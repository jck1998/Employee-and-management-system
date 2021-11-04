package com.graduationproject.controller;


import com.graduationproject.entity.Emp;
import com.graduationproject.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("emp")
@CrossOrigin
@Slf4j
public class EmpController {

  @Autowired
  private EmpService empService;

  @Value("${photo.dir}")
  private String realPath;

  //修改员工信息
  @PostMapping("update")
  public Map<String,Object> update(Emp emp, MultipartFile photo) throws IOException {
    log.info("员工信息:[{}]",emp.toString());

    Map<String, Object> map = new HashMap<>();

    try {
      if (photo!=null&&photo.getSize()!=0){
        log.info("头像信息:[{}]",photo.getOriginalFilename());
        //头像保存
        String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
        photo.transferTo(new File(realPath,fileName));
        //设置头像地址
        emp.setPath(fileName);
      }
      //保存员工信息
      empService.update(emp);
      map.put("state",true);
      map.put("message","员工信息保存成功");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("state",false);
      map.put("message","员工信息保存失败");
    }
    return map;
  }


  //根据id查询员工信息
  @GetMapping("findHead")
  public Emp findHead(String id){
    log.info("查询员工信息的id:[{}]",id);
    return empService.findHead(id);
  }



  //删除员工信息
  @GetMapping("delete")
  public Map<String,Object> delete (String id){
    log.info("删除员工的id:[{}]",id);
    Map<String, Object> map = new HashMap<>();
    try {
      //删除员工头像
      Emp emp = empService.findHead(id);
      File file = new File(realPath, emp.getPath());
      if (file.exists())file.delete();//删除头像

      //删除员工信息
      empService.delete(id);
      map.put("state",true);
      map.put("message","删除成功");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("state",false);
      map.put("message","删除信息失败");
    }
    return map;
  }

  //保存员工信息
  @PostMapping("save")
  public Map<String,Object> save(Emp emp, MultipartFile photo) throws IOException {
    log.info("员工信息:[{}]",emp.toString());
    log.info("头像信息:[{}]",photo.getOriginalFilename());
    Map<String, Object> map = new HashMap<>();

    try {
      //头像保存
      String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
      photo.transferTo(new File(realPath,fileName));
      //设置头像地址
      emp.setPath(fileName);
      //保存员工信息
      empService.save(emp);
      map.put("state",true);
      map.put("message","员工信息保存成功");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("state",false);
      map.put("message","员工信息保存失败");
    }
    return map;
  }

  //获取员工列表的方法
  @GetMapping("find")
  public List<Emp> find(String deptId){
    return empService.find(deptId);
  }
}
