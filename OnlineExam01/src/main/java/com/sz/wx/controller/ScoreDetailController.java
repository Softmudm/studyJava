package com.sz.wx.controller;

import com.sz.wx.model.ScoreDetailItems;
import com.sz.wx.service.ScoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scoredetail")
public class ScoreDetailController {

    @Autowired
    ScoreDetailService scoreDetailService;

    @RequestMapping("/getDetailList")
    public List<ScoreDetailItems> getDetailList(@RequestBody Map<String,Object> map){
        Integer scoreId = Integer.parseInt(String.valueOf(map.get("scoreId")));
        List<ScoreDetailItems> detailList = scoreDetailService.getDetailList(scoreId);
        for (ScoreDetailItems scoreDetailItems : detailList) {
            if(scoreDetailItems.getUanswer()==null){
                scoreDetailItems.setUanswer("");
            }
        }
        return detailList;
    }
}
