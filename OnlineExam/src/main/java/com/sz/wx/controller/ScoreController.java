package com.sz.wx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sz.wx.model.*;
import com.sz.wx.service.ItemsService;
import com.sz.wx.service.ScoreDetailService;
import com.sz.wx.service.ScoreService;
import com.sz.wx.util.Info;
import com.sz.wx.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @Autowired
    ItemsService itemsService;
    @Autowired
    ScoreDetailService scoreDetailService;

    //交卷方法
    @RequestMapping("/countSocre")
    public Info countScore(@RequestBody Map<String,Object> map, HttpServletRequest request){
        Integer paperid = Integer.parseInt(String.valueOf(map.get("paperid")));
        map.remove("paperid",paperid);
        //获取试卷的所有题目
        List<Items> ilist = itemsService.getItemsListByPaperid(paperid);
        int score = 0;  //总分
        int rights = 0; //正确题数
        int errors = 0; //错误题数
        //查出试卷的所有试题
        List<ScoreDetail> slist = new ArrayList<>();
        //循环改题
        for (Items items : ilist) {
            String uanswer = (String) map.get(String.valueOf(items.getEid()));
            String ekey = items.getEkey();
            String escore = items.getEscore();
            //填空，判断，单选
            if(items.getEtype()==1||items.getEtype()==2||items.getEtype()==3){
                if(uanswer==null||!ekey.equals(uanswer)){
                    errors++;
                    escore = "0";
                }else{
                    rights++;
                }
            //多选，问答
            }else{
                if(uanswer==null||!ekey.contains(uanswer)){
                    errors++;
                    escore = "0";
                }else if(!ekey.equals(uanswer)){
                    errors++;
                    escore = String.valueOf((Integer.parseInt(escore)/2));
                }else{
                    rights++;
                }
            }
            ScoreDetail scoreDetail = new ScoreDetail();
            scoreDetail.setEid(items.getEid());
            scoreDetail.setUanswer(uanswer);
            scoreDetail.setUpoint(Integer.parseInt(escore));
            slist.add(scoreDetail);
            //总分
            score = score+Integer.parseInt(escore);
        }
        User user = (User) request.getSession().getAttribute("user");
        Score record = new Score();
        record.setUserid(user.getUserid());
        record.setPaperid(paperid);
        record.setScore(score);
        record.setRights(rights);
        record.setErrors(errors);
        int scoreId = scoreService.insertReturnId(record);
        System.out.println(scoreId);
        for (ScoreDetail scoreDetail : slist) {
            scoreDetail.setScoreid(record.getScoreid());
        }
        int num = scoreDetailService.insertList(slist);
        return new Info(String.valueOf(score));
    }

    //查询我的试卷
    @RequestMapping("/getScoreList")
    public PageResult<ScorePaper> getScoreList(@RequestBody Map<String,Object> map,HttpServletRequest request){
        Integer pageNo = (Integer) map.get("pageNo");
        Integer pageSize = (Integer) map.get("pageSize");
        pageNo = pageNo==null?1:pageNo;
        pageSize = pageSize==null?5:pageSize;
        User user = (User)request.getSession().getAttribute("user");
        map.put("userId",user.getUserid());
        PageHelper.startPage(pageNo,pageSize);
        Page<ScorePaper> list = (Page<ScorePaper>) scoreService.selectByPaperName(map);
        return new PageResult<ScorePaper>(
                list.getPageNum(),
                list.getPageSize(),
                list.getTotal(),
                list.getPages(),
                list.getResult());
    }
}
