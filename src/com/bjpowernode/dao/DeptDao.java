package com.bjpowernode.dao;

import com.bjpowernode.model.Dept;
import com.bjpowernode.util.SqlSession;

import java.util.List;

/**
 * @author Yang
 * @create 2020/4/26 22:06
 */
public class DeptDao {

    public List findAll() {
        String sql = "select * from dept";
        List deptList = SqlSession.selectList(sql, Dept.class);
        return deptList;
    }
}
