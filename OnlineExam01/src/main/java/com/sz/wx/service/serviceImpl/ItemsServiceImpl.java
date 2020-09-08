package com.sz.wx.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.sz.wx.dao.ItemsMapper;
import com.sz.wx.model.Items;
import com.sz.wx.model.ItemsExample;
import com.sz.wx.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //这两个Template的区别是使用的序列化的类不同，上面的是String使用的，下面的会先序列化成字节数组再存进数据库。
    //private RedisTemplate redisTemplate;

    //根据试卷id查对应的题目集合
    public List<Items> getItemsListByPaperid(int paperid){
        List<Items> list = JSON.parseArray(stringRedisTemplate.opsForValue().get(paperid+""),Items.class);
        if(list==null){
            System.out.println("redis中没有，从数据库中查！！");
            ItemsExample example = new ItemsExample();
            ItemsExample.Criteria criteria = example.createCriteria();
            criteria.andEpaperidEqualTo(paperid);
            list = itemsMapper.selectByExample(example);
            stringRedisTemplate.opsForValue().set(paperid+"",JSON.toJSONString(list));
        }
        return list;
    }
}
