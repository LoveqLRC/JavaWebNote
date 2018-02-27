package com.loveqrc.note.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

@WebServlet(
        name = "RemCookieServlet",
        urlPatterns = "/remcookieservlet"
)
public class RemCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Cookie lastTimeCookie =
                CookieUtils.getCookieByName("lastTime", cookies);
        if (lastTimeCookie != null) {
            String time = lastTimeCookie.getValue();
            long lastTime = Long.parseLong(time);
            Date date = new Date(lastTime);
            DateFormat dateFormat = DateFormat.getDateInstance();
            writer.print("上一次访问时间是:" + date.toLocaleString());
        } else {
            writer.print("第一次访问");
        }

        lastTimeCookie = new Cookie("lastTime",
                new Date().getTime() + "");

        lastTimeCookie.setMaxAge(3600);
        lastTimeCookie.setPath(req.getContextPath() + "/");
        resp.addCookie(lastTimeCookie);
    }
}
