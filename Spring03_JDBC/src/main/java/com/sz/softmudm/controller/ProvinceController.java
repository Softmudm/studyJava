package com.sz.softmudm.controller;

import com.alibaba.fastjson.JSON;
import com.sz.softmudm.modal.Province;
import com.sz.softmudm.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

//负责将这个类注册到spring上下文中
@Controller
//指定父路径
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    //指定子路径
    //查询列表
    @RequestMapping(value = "/getProvince",method = RequestMethod.POST)
    //在处理方法入参处使用 @RequestParam 获取参数，可以把请求参数传递给请求方法
    //相当于request.getParameter("name")获取参数
    //这里省略了，name不一样就不能省略如：@RequestParam("username") String pname
    public String getProvince(@RequestParam String pname, Model model){
        pname = pname==null?"":pname;
        model.addAttribute("list",provinceService.getProvinceListByPname(pname));
        return "provincelist";
    }

    //查询省下拉框
    @RequestMapping("/getDropDown")
    @ResponseBody
    public String getDropDown(){
        return JSON.toJSONString(provinceService.getProvinceListByFid(0));
    }

    //删除省或市
    @RequestMapping("/delProvince")
    @ResponseBody
    public String delProvince(int pid,Model model){
        int flag = provinceService.deleteProvince(pid);
        String msg = "{\"message\":\"删除失败！\",\"i\":2}";
        if(flag==1){
            msg = "{\"message\":\"删除成功！\",\"i\":1}";
        }
        return msg;
    }

    //添加省或市
    @RequestMapping("/addProvince")
    @ResponseBody
    public String addProvince(String pname,String cname){
        String msg = "";
        if(cname==null||"".equals(cname)){//增加省
            if(provinceService.getProvinceByPname(pname)==null){
                int f = provinceService.addProvince(new Province(pname,0));
                if(f==1){
                    msg = "{\"msg\":\"添加"+pname+"省成功！\",\"icon\":1}";
                }else{
                    msg = "{\"msg\":\"添加"+pname+"省失败！\",\"icon\":2}";
                }
            }else{
                msg = "{\"msg\":\""+pname+"省已存在，添加失败！\",\"icon\":2}";
            }
        }else{//增加市
            int pid;
            Province province = provinceService.getProvinceByPname(pname);
            if(province==null){
                pid = provinceService.getProvinceId();
                provinceService.addProvince1(new Province(pid,pname,0));
            }else{
                pid = province.getPid();
            }
            Province province2 = provinceService.getProvinceByPname(cname);
            if(province2==null){
                int flag = provinceService.addProvince(new Province(cname,pid));
                if(flag==1){
                    msg = "{\"msg\":\"添加"+cname+"市成功！\",\"icon\":1}";
                }else{
                    msg = "{\"msg\":\"添加"+cname+"市失败！\",\"icon\":2}";
                }
            }else{
                msg = "{\"msg\":\""+cname+"市已存在，添加失败！\",\"icon\":2}";
            }
        }
        return msg;
    }

    //修改省或市
    @RequestMapping("/updateProvince")
    @ResponseBody
    public String updateProvince(Integer pid,Integer cid,String pname,String cname){
        String msg = "";
        if(cid==null||"".equals(cid)){//修改省
            if(provinceService.getProvinceByPname(pname)==null){
                int f = provinceService.updateProvince(new Province(pid,pname,0));
                if(f==1){
                    msg = "{\"msg\":\"修改"+pname+"成功！\",\"icon\":1}";
                }else{
                    msg = "{\"msg\":\"修改"+pname+"失败！\",\"icon\":2}";
                }
            }else{
                msg = "{\"msg\":\""+pname+"已存在，修改失败！\",\"icon\":2}";
            }
        }else{//修改市
            int pid1;
            Province province = provinceService.getProvinceByPname(pname);
            if(province==null){
                pid1 = provinceService.getProvinceId();
                provinceService.addProvince(new Province(pid1,pname,0));
            }else{
                pid1 = province.getPid();
            }
            if(provinceService.getCityByPname(cname,pid1)==null){
                int flag = provinceService.updateProvince(new Province(cid,cname,pid1));
                if(flag==1){
                    msg = "{\"msg\":\"修改"+cname+"成功！\",\"icon\":1}";
                }else{
                    msg = "{\"msg\":\"修改"+cname+"失败！\",\"icon\":2}";
                }
            }else{
                msg = "{\"msg\":\""+cname+"已存在，修改失败！\",\"icon\":2}";
            }
        }
        return msg;
    }
}
