package com.sz.order.otherinterface;

import com.sz.order.otherinterface.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-client" , fallback = UserServiceImpl.class)
public interface UserService {
}
