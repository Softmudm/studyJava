package com.sz.meituan.servlets;

import com.sz.meituan.dao.AppraiseDao;
import com.sz.meituan.dao.FoodDao;
import com.sz.meituan.dao.ReplyDao;
import com.sz.meituan.model.Appraise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/foodappraise")
public class SelAppraiseServlet extends HttpServlet {
    private AppraiseDao appraiseDao = new AppraiseDao();
    private FoodDao foodDao = new FoodDao();
    private ReplyDao replyDao = new ReplyDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fid = Integer.parseInt(request.getParameter("fid"));
        request.setAttribute("f",foodDao.getFoodByFid(fid));
        List<Appraise> appraiseList = appraiseDao.selAppraiseByFid(fid);
        for (Appraise appraise : appraiseList) {
            appraise.setReplyList(replyDao.selReplyByAppraiseid(appraise.getAppraiseid()));
        }
        request.setAttribute("list",appraiseList);
        request.getRequestDispatcher("foodappraise.jsp").forward(request,response);
    }
}
