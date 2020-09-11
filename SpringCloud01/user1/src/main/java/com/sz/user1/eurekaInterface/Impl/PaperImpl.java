package com.sz.user1.eurekaInterface.Impl;

import com.sz.user1.eurekaInterface.PaperInterface;
import com.sz.user1.model.Paper;
import org.springframework.stereotype.Component;

import java.util.*;

//熔断器Hystrix需要的实现类，在熔断后会调用这个里面的方法。
@Component
public class PaperImpl implements PaperInterface {
    @Override
    public List<Paper> getPaperlistPage(String papername, Integer pageNum, Integer pageSize) {
        System.out.println("Paper熔断器起作用了！");
        return new ArrayList<>();
    }
}
