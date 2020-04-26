package com.bjpowernode.controller;

import com.bjpowernode.dao.EmpDao;
import com.bjpowernode.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Yang
 * @create 2020/4/26 22:37
 */
public class EmpFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        List<Emp> empList = null;
        PrintWriter out = null;
        //1.JDBC查询所有的职员信息
        empList = dao.findEmpAll();
        //2.response将查询职员信息写入到响应包
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        out.write("<center>");
        out.write("<table border='2'>");
        out.write("<tr>");
        out.write("<td>职员编号</td>");
        out.write("<td>职员姓名</td>");
        out.write("<td>职员职位</td>");
        out.write("<td>职员工资</td>");
        out.write("</tr>");
        for (Emp emp : empList) {
            out.write("<tr>");
            out.write("<td>" + emp.getEmpNo() + "</td>");
            out.write("<td>" + emp.getEname() + "</td>");
            out.write("<td>" + emp.getJob() + "</td>");
            out.write("<td>" + emp.getSal() + "</td>");
            out.write("</tr>");
        }

        out.write("</table>");
        out.write("</center>");
    }
}
