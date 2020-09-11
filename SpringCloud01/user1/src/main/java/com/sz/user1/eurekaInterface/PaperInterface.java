package com.sz.user1.eurekaInterface;

import com.sz.user1.eurekaInterface.Impl.PaperImpl;
import com.sz.user1.model.Paper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Feign通过动态代理实现
@FeignClient(value = "eureka-client-paper",fallback = PaperImpl.class)
public interface PaperInterface {
    //分页查询试卷列表
    @GetMapping("/papers/{papername}")
    public List<Paper> getPaperlistPage(@PathVariable("papername")String papername ,@RequestParam Integer pageNum,@RequestParam Integer pageSize);
}
