package com.spcld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)//支持链式写法，Dept d = new Dept(); d.setDeptno(11L).setDname("IT").setDb_source("DB01");
public class Dept implements Serializable// entity --orm--- db_table
{
    private Long 	deptno; // 主键
    private String 	dname; // 部门名称
    private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    // 声明一个单参的构造函数
    public Dept(String dname) {
        super();
        this.dname = dname;
    }


}
