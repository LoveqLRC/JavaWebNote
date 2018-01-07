package com.loveqrc.note.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求常有方法演示
 */
@WebServlet(
        urlPatterns = "/requestmethod"
)
public class RequestMethodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        //请求方式：例如Get Post
        String method = request.getMethod();
        System.out.println("method:" + method);

        //获取请求资源
        // 获取的是 从项目名到参数之前的内容 /requestmethod
        String requestURI = request.getRequestURI();

        //获取的带协议的完整路径  http://localhost:8080/requestmethod
        String requestURL = request.getRequestURL().toString();
        System.out.println("requestURI" + requestURI);
        System.out.println("requestURL" + requestURL);

        //获取请求参数的字符串 username=rc&password=123
        String queryString = request.getQueryString();
        System.out.println("Get的请求参数:" + queryString);

        //获取协议版本 HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println("协议:" + protocol);

        //获取请求Ip
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr:" + remoteAddr);

        //获取项目名字
        String contextPath = request.getContextPath();
        System.out.println("项目路径:" + contextPath);

    }
}
