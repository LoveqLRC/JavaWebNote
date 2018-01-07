package com.loveqrc.note.download;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(
        name = "download",
        urlPatterns = "/download"
)
/**
 * 下载
 */
public class DownLoadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("name");

//        fileName = new String(fileName.getBytes("iso8859-1"), "utf-8");
        ServletContext context = getServletContext();
        String fileMimeType = context.getMimeType(fileName);

        resp.setContentType(fileMimeType);

        resp.setHeader("content-disposition",
                "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
        InputStream is = context.getResourceAsStream("/download/" + fileName);
        ServletOutputStream outputStream = resp.getOutputStream();

        IOUtils.copy(is, outputStream);

        is.close();
        outputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
