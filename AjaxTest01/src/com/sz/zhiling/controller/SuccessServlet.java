package com.sz.zhiling.controller;

import com.alibaba.fastjson.JSON;
import com.sz.zhiling.dao.CountryDao;
import com.sz.zhiling.dao.PersonDao;
import com.sz.zhiling.dao.RoleDao;
import com.sz.zhiling.entity.Country;
import com.sz.zhiling.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    private CountryDao countryDao = new CountryDao();
    private RoleDao roleDao = new RoleDao();
    private PersonDao personDao = new PersonDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int countryId = Integer.parseInt(request.getParameter("countryId"));
        int roleId = Integer.parseInt(request.getParameter("roleId"));
        if(countryId!=0 && roleId==0){
             response.getWriter().print(JSON.toJSONString(personDao.selPersonByCountry(countryId)));
        }else if(countryId==0 && roleId!=0){
            response.getWriter().print(JSON.toJSONString(personDao.selPersonByRole(roleId)));
        }else{
            response.getWriter().print(JSON.toJSONString(personDao.selPersonByRoleAndCountry(roleId,countryId)));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Country> clist = countryDao.selAllCountry();
        List<Role> rlist = roleDao.selAllRole();
        String result = "{\"countrylist\":"+ JSON.toJSONString(clist)+",\"rolelist\":"+JSON.toJSONString(rlist)+"}";
        response.getWriter().print(result);
    }
}
