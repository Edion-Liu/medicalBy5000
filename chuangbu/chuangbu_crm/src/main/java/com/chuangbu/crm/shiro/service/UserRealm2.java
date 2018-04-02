package com.chuangbu.crm.shiro.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chuangbu.common.util.security.Encodes;
import com.chuangbu.crm.shiro.bean.Permission;
import com.chuangbu.crm.shiro.bean.Role;
import com.chuangbu.crm.shiro.bean.ShiroInit;
import com.chuangbu.crm.shiro.bean.User;
import com.google.common.base.Objects;

@Service
public class UserRealm2 extends AuthorizingRealm {

	static final Logger logger = LoggerFactory.getLogger(UserRealm2.class);

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;

		User user = ShiroInit.users.get(token.getUsername());
		if (user == null) {
			throw new ShiroException("此用户不存在！");
		}

		List<Role> roles = ShiroInit.getRoleByUser(user);
		if (doCaptchaValidate(token)) {
			byte[] salt = Encodes.decodeHex(user.getSalt());
			ShiroUser shiroUser = new ShiroUser(user.getId(), user.getNo(), user.getLoginName(), user.getName(), roles);
			// 设置用户session
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user", user);
			return new SimpleAuthenticationInfo(shiroUser, user.getPassword(), ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();

		User user = ShiroInit.users.get(shiroUser.loginName);

		SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getNo()),
				SecurityUtils.getSubject().getPrincipals());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 赋予角色
		for (Role r : ShiroInit.getRoleByUser(user)) {
			info.addRole(r.getCode());
			// 赋予权限
			for (Permission permission : ShiroInit.getPermissionByRole(r)) {
				if (StringUtils.isNotBlank(permission.getCode()))
					info.addStringPermission(permission.getCode());
			}
		}

		logger.info("登录者权限[{}]", info.getStringPermissions());
		return info;
	}

	/**
	 * 验证码校验
	 * 
	 * @param token
	 * @return boolean
	 */
	protected boolean doCaptchaValidate(UsernamePasswordCaptchaToken token) {

		String captcha = (String) SecurityUtils.getSubject().getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
			throw new ShiroException("验证码错误！");
		}

		return true;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@SuppressWarnings("all")
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ShiroInit.HASH_ALGORITHM);
		matcher.setHashIterations(ShiroInit.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public Integer id;// ID
		public String no;// 编号
		public String loginName;// 登录名
		public String name;// 姓名

		private List<Role> roles;// 角色列表

		public ShiroUser(Integer id, String no, String loginName, String name, List<Role> roles) {
			this.id = id;
			this.no = no;
			this.loginName = loginName;
			this.name = name;
			this.roles = roles;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getNo() {
			return no;
		}

		public String getName() {
			return name;
		}

		public List<Role> getRoles() {
			return roles;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载hashCode,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(loginName);
		}

		/**
		 * 重载equals,只计算loginName;
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				if (other.loginName != null) {
					return false;
				}
			} else if (!loginName.equals(other.loginName)) {
				return false;
			}
			return true;
		}
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
