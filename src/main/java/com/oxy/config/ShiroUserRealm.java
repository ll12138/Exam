package com.oxy.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.oxy.model.User;
import com.oxy.service.UserService;


public class ShiroUserRealm extends AuthorizingRealm {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroUserRealm.class);

	@Autowired
	private UserService sysUserService;

	/**
	 * 返回权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		LOGGER.info("返回权限信息");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		return authorizationInfo;
	}

	/**
	 * 返回认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		LOGGER.info("返回认证信息");
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String account = usernamePasswordToken.getUsername();
		String password = new String(usernamePasswordToken.getPassword());
		User sysUser = null;
		try {
			sysUser = sysUserService.login(account, password,null);
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
		if (sysUser != null) {
			return new SimpleAuthenticationInfo(sysUser, token.getCredentials(), this.getName());
		} else {
			throw new AuthenticationException("用户名或密码有误，请重新输入！");
		}
	}
}
