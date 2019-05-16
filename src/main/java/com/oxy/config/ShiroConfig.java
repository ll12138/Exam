package com.oxy.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 */
@Configuration
public class ShiroConfig {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	

	@Bean
	public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		shiroFilterFactoryBean.setLoginUrl("/exam/login");

		Map<String, Filter> filterMap = new HashMap<>();
		filterMap.put("authc", myShiroUserFilter());
		shiroFilterFactoryBean.setFilters(filterMap);

		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/exam/**", "authc");// 拦截
		filterChainDefinitionMap.put("/exam/login", "anon");// 不拦截
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterFactoryBean;
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroUserRealm());
		return securityManager;
	}

	/**
	 * 自定义Filter
	 */
	@Bean
	public ShiroUserFilter myShiroUserFilter() {
		ShiroUserFilter shiroUserFilter = new ShiroUserFilter();
		return shiroUserFilter;
	}

	/**
	 * 身份认证
	 */
	@Bean
	public ShiroUserRealm myShiroUserRealm() {
		ShiroUserRealm shiroUserRealm = new ShiroUserRealm();
		return shiroUserRealm;
	}



}
