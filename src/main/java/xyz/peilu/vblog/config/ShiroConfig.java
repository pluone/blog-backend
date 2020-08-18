package xyz.peilu.vblog.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.peilu.vblog.shiro.AccountRealm;
import xyz.peilu.vblog.shiro.JWTFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shrio配置，使用了Redis作为存储
 *
 * Shiro-Redis的配置都在shiro-redis-spring-boot-starter.jar中的自动配置类ShiroRedisAutoConfiguration中，
 *
 * 其中已经配置了SessionManager的默认实现类是DefaultWebSessionManager, SessionDao是RedisSessionDao
 *
 * 配置了SecurityManager，注入了List<Realm>，并注入了SessionManager和CacheManager，因此程序中仅需要自定义Realm即可
 *
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/**", "jwt");
        chainDefinition.addPathDefinitions(filterMap);
        return chainDefinition;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager,
                                                  ShiroFilterChainDefinition shiroFilterChainDefinition,
                                                  JWTFilter jwtFilter) {
        Map<String, String> filterChainMap = shiroFilterChainDefinition.getFilterChainMap();

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        Map<String, Filter> filters = new HashMap<>();
        filters.put("jwt", jwtFilter);
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }
}
