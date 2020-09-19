package com.sz.ccms.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

    /**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //根据Token获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) authenticationToken.getCredentials());

        return null;
    }
    //权限认证
    //principals （身份）和 credentials（证明）
    //身份是用户的唯一标识    证明是
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        return null;
    }
}
