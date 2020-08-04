package com.wang.servlet;

import com.wang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author wang
 * @creatTime 2020/7/30
 */
public class SessionDemon01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决乱码问题
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到Session
        HttpSession session = req.getSession();

        //给Session中存东西
        session.setAttribute("name", new Person("名字", 1));

        //获取Session的ID
        String sessionId = session.getId();

        //判断Session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功，ID：" + sessionId);
        }else {
            resp.getWriter().write("session已经在服务器中存在了，ID：" + sessionId);
        }

        //Session创建的时候做了什么事情
//        Cookie cookie = new Cookie("JSESSIONID", sessionId);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
