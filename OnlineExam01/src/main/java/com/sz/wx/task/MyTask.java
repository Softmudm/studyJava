package com.sz.wx.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyTask {

    //cron的格式依次是：Seconds Minutes Hours DayofMonth Month DayofWeek Year (秒 分 时 日 月 周 [年])
    //*任意值都匹配
    //a-b表示值在a到b的一个范围内变化一次触发一次
    //a/b表示值到a时开始，每过b时间触发一次
    //a,b表示值为a或b时触发
    //(?,L,W,C用在DayofMonth和DayofWeek)?匹配任意值,L匹配最后一天,W匹配工作日
    @Scheduled(cron="0/5 * * * * ?")
    public void taskTime(){
        System.out.println("现在时间是："+new Date());
    }

}
