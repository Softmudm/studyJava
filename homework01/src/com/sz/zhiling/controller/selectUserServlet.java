package com.sz.zhiling.controller;

import com.sz.zhiling.dao.LikeDao;
import com.sz.zhiling.dao.RoleDao;
import com.sz.zhiling.dao.UserDao;
import com.sz.zhiling.entity.Like;
import com.sz.zhiling.entity.Role;
import com.sz.zhiling.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectUserServlet")
public class selectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();
        LikeDao likeDao = new LikeDao();
        String n = request.getParameter("pageno");
        String s = request.getParameter("pagesize");
        String keyword = request.getParameter("keyword");
        int pageno = ("".equals(n)||n==null)? 1:Integer.parseInt(n);
        int pagesize = ("".equals(s)||s==null)? 5:Integer.parseInt(s);
        keyword = keyword==null? "":keyword;
        List<User> list = userDao.selectPageUsers(pageno,pagesize,keyword);
        for (User user : list) {
            user.setLikeids(likeDao.selectLikeidsById(user.getUserid()));
        }
        List<Role> rolelist = roleDao.selectAllRole();
        List<Like> likelist = likeDao.selectAllLikes();
        int pgnm = userDao.countAll(keyword);
        int currentPage = pgnm%pagesize==0?pgnm/pagesize:pgnm/pagesize+1;
        request.setAttribute("list",list);
        request.setAttribute("rolelist",rolelist);
        request.setAttribute("likelist",likelist);
        request.setAttribute("pageno",pageno);
        request.setAttribute("pagesize",pagesize);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("keyword",keyword);
        request.setAttribute("pgnm",pgnm);
        request.getRequestDispatcher("userslist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
