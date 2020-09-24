package com.sz.ccms.config.shiro;

import com.sz.ccms.entity.Permission;
import com.sz.ccms.service.PermissionService;
import com.sz.ccms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个类是用来初始化权限和刷新权限的
 */
@Service
public class ShiroServiceImpl {
    @Autowired
    PermissionService permissionService;
    @Autowired
    RoleService roleServie;
    /**
     * 初始化权限(从数据库查询再加入拦截器)
     * 实现动态控制权限
     */
    public Map<String, String> loadFilterChainDefinitions() {
        List<Permission> permissionList = permissionService.getAll();
        // 权限控制map.从数据库获取
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        if (permissionList.size() > 0) {
            for (Permission permission : permissionList) {
                //找出权限中的uri
                String uri = permission.getPermissionUri();
                if(StringUtils.isEmpty(uri)){
                    continue;
                }
                List<String> roleNameList = roleServie.getRoleNameByPermissionId(permission.getPermissionId());
                String roles = "roles["+String.join(",",roleNameList)+"]";
                filterChainDefinitionMap.put(uri,roles);
            }
        }
        filterChainDefinitionMap.put("/login", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "anon");
        //放行静态资源
        filterChainDefinitionMap.put("/assets/**", "anon");
        filterChainDefinitionMap.put("/layer/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }

}
