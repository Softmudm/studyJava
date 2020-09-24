package com.sz.ccms.config.shiro;

import com.sz.ccms.entity.Manager;
import com.sz.ccms.entity.Role;
import com.sz.ccms.service.ManagerService;
import com.sz.ccms.service.PermissionService;
import com.sz.ccms.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    ManagerService managerService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    /**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     * principals （身份）和 credentials（证明） 就是账号密码
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据Token获取用户名
        String account = (String) authenticationToken.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("账号"+account+"密码"+password+"，开始登录。。");
        //使用账号作为盐
        ByteSource credentialsSalt = ByteSource.Util.bytes(account);
        // 去数据库查询用户
        Manager manager = managerService.getManager(new Manager(account,(new SimpleHash("md5",password,credentialsSalt,1)).toString()));
        if(manager==null){// 失败则抛出身份认证异常错误
            System.out.println("账号密码错误。。");
            throw new IncorrectCredentialsException();
        }
        System.out.println("登陆成功。。");
        //其实这个方法只是用来验证账号是否存在，下面这个对象才还会对密码进行比较
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(manager, manager.getManagerPassword(),credentialsSalt, getName());
        return simpleAuthenticationInfo;
    }
    //权限认证，授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始用户授权。。。。");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户名
        Manager manager = (Manager) principalCollection.getPrimaryPrincipal();
        String roleId = manager.getRoleId();
        Role role = roleService.getRoleByRoleId(roleId);
        //将角色信息返回
        simpleAuthorizationInfo.addRole(role.getRoleName());
        //如果角色-权限表中没有权限则直接返回null
        List<String> list = permissionService.getPermissionIdByRoleId(roleId);
        if(list.size()==0){
            return null;
        }
        return simpleAuthorizationInfo;
    }
}
