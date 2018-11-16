package com.dwyanewang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class ServletTest extends HttpServlet {

    private static final long serialVersionUID = 5247783547227659354L;

    //重写get方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置返回类型为json
        resp.setContentType("application/json");
        //设置返回字符集为utf8
        resp.setCharacterEncoding("utf-8");
        //输出对象
        PrintWriter writer = resp.getWriter();
        //输出消息
        writer.write("执行ServletTest内doGet方法成功");
        writer.close();
    }


}
