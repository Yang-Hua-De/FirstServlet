package com.bjpowernode.controller;

import com.bjpowernode.dao.DeptDao;
import com.bjpowernode.model.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Yang
 * @create 2020/4/26 22:09
 */
public class DeptFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptDao dao = new DeptDao();
        List<Dept> deptList = null;
        PrintWriter out = null;
        // 1.JDBC 查询所有信息
        deptList = dao.findAll();
        // 2.相应对象将查询结果写入到响应体
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        out.write("<center>");
        out.write("<table border='2'");
        out.write("<tr>");
        out.write("<td>部门编号</td>");
        out.write("<td>部门名称</td>");
        out.write("<td>部门位置</td>");
        out.write("</tr>");
        for (Dept dept : deptList) {
            out.write("<tr>");
            out.write("<td>" + dept.getDeptno() + "</td>");
            out.write("<td>" + dept.getDname() + "</td>");
            out.write("<td>" + dept.getLoc() + "</td>");
            out.write("</tr>");

        }
        out.write("</table>");
        out.write("<center>");
    }
}
