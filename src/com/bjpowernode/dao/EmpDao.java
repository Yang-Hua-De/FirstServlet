package com.bjpowernode.dao;

import com.bjpowernode.model.Emp;
import com.bjpowernode.util.SqlSession;

import java.util.List;

/**
 * @author Yang
 * @create 2020/4/26 22:31
 */
public class EmpDao {
    public List findEmpAll(){
        String sql ="select * from emp";
        List list = SqlSession.selectList(sql, Emp.class);
        return list;
    }
}
