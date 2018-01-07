package com.loveqrc.note.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头
 */
@WebServlet(
        urlPatterns = "/requestheader"
)
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器内核
        String agent = request.getHeader("user-agent");
        System.out.println("agent:" + agent);
        //从哪个页面链接过来 防盗链
        String referer = request.getHeader("referer");
    }

}
