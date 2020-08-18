## 项目后端

### 项目技术栈
spring-boot, mybatis-plus, shiro-redis, jwt


### 关于shiro-redis的配置
引用了第三方jar包shiro-redis-spring-boot-starter，主要包含shiro-redis的和信代码，和自动配置类。
自动配置类中默认配置了securityManager, 其中注入了realms， sessionManager, redisCacheManager, 

realm需要自己在项目代码中写，然后通过注入到SecurityManager中，
同时需要配置JwtFilter，实现了shiro的AuthenticatingFilter，是进行认证的关键一步。
/login接口会在登录成功后颁发JwtToken，然后通过前面配置的过滤器进行登录的认证。


```java
    @Bean
    @ConditionalOnMissingBean
    public SessionsSecurityManager securityManager(List<Realm> realms, SessionManager sessionManager, RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(realms);
        securityManager.setSessionManager(sessionManager);
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }
```
