package com.sz.ccms.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;

    //权限redis缓存前缀
    private static final String CACHE_KEY = "shiro:cache:";
    private static final String SESSION_KEY = "shiro:session:";
    private static final String NAME = "manager.name";
    private static final String VALUE = "/";

    /**
     * 定义加密方法和加密次数
     * MyRealm中的doGetAuthenticationInfo方法会使用这里的方法加密token的密码再和simpleAuthenticationInfo中的密码比较
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    @Bean
    //注入Realm核心管理器
    public SecurityManager getSecurityManager(MyRealm myRealm, RedisCacheManager redisCacheManager,SessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        securityManager.setCacheManager(redisCacheManager);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    //注入Filter工厂，设置过滤跳转条件
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager,ShiroServiceImpl shiroServiceImpl){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加拦截器地址,常用的过滤器:
        // anon:无须认证即可访问
        // authc:必须认证才可访问
        // user:使用rememberMe的功能可以直接访问
        // perms:该资源必须得到资源权限才可访问
        // roles:该资源必须得到角色权限才可访问

        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/goLogin");

        //这里没有配置，在ShiroServiceImpl中动态配置的拦截路径
        Map<String,Filter> filterMap =  new LinkedHashMap<>();
        //配置自定义拦截器
        filterMap.put("roles",rolesAuthorizationFilter());
        //配置自定义拦截路径
        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroServiceImpl.loadFilterChainDefinitions());
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义权限拦截规则
     */
    @Bean
    public CustomRolesAuthorizationFilter rolesAuthorizationFilter(){
        return new CustomRolesAuthorizationFilter();
    }

    /**
     * Redis集群使用RedisClusterManager，单个Redis使用RedisManager
     */
    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisHost);
        redisManager.setPort(redisPort);
        return redisManager;
    }

    /**
     * shiro缓存管理器;
     * 需要添加到securityManager中
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisManager redisManager){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        //redis中针对不同用户缓存
        redisCacheManager.setPrincipalIdFieldName("managerAccount");
        //用户权限信息缓存时间(一天)
        redisCacheManager.setExpire(86400);
        //设置redis前缀shiro:cache:
        redisCacheManager.setKeyPrefix(CACHE_KEY);
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }

    /**
     * SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件
     * MemorySessionDAO 直接在内存中进行会话维护
     * EnterpriseCacheSessionDAO  提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
     * @return
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        //session在redis中的保存时间,最好大于session会话超时时间(一天)
        redisSessionDAO.setExpire(86400);
        //设置redis前缀shiro:session:
        redisSessionDAO.setKeyPrefix(SESSION_KEY);
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    @Bean
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName(NAME);
        simpleCookie.setValue(VALUE);
        return simpleCookie;
    }

    @Bean
    public DefaultWebSessionManager sessionManager(RedisSessionDAO sessionDAO, SimpleCookie simpleCookie) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(simpleCookie);
        return sessionManager;
    }

    //开启shiro aop注解支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    /**
     * 必须（thymeleaf页面使用shiro标签控制按钮是否显示）
     * 未引入thymeleaf包，Caused by: java.lang.ClassNotFoundException: org.thymeleaf.dialect.AbstractProcessorDialect
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public MyRealm getMyRealm(RedisCacheManager redisCacheManager){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        myRealm.setCacheManager(redisCacheManager);
        myRealm.setAuthenticationCachingEnabled(false);
        myRealm.setAuthorizationCachingEnabled(false);
        return myRealm;
    }
}
