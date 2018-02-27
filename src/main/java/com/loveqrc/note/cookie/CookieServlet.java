package com.loveqrc.note.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "cookie",
        urlPatterns = "/cookie"
)

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        Cookie a = new Cookie("aKey", "aValue");
        Cookie b = new Cookie("bKey", "bValue");
        Cookie c = new Cookie("cKey", "cValue");

        resp.addCookie(a);
        resp.addCookie(b);
        resp.addCookie(c);

        writer.print("cookie 已写回");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
