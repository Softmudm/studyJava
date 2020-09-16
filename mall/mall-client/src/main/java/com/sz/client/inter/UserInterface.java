package com.sz.client.inter;

import com.sz.client.inter.impl.UserImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user-client",fallback = UserImpl.class)
public interface UserInterface {

}
