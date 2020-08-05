package com.sz.meituan.servlets;

import com.sz.meituan.dao.ReplyDao;
import com.sz.meituan.model.Reply;
import com.sz.meituan.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addreply")
public class AddReplyServlet extends HttpServlet {
    private ReplyDao replyDao = new ReplyDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appraiseid = Integer.parseInt(request.getParameter("appraiseid"));
        String content = request.getParameter("reply");
        User user = (User)request.getSession().getAttribute("user");
        int fid = Integer.parseInt(request.getParameter("fid"));
        Reply reply = new Reply(appraiseid,user.getUserid(),content);
        replyDao.addReply(reply);
        response.sendRedirect("/foodappraise?fid="+fid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
