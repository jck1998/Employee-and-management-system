package com.graduationproject.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Emp implements Serializable {
  private String id;
  private String name;
  private String path;
  private Double salary;
  private Integer age;

  private Dept dept;//部门信息

  private String deptId;//部门id
}
