package com.chuangbu.weixin.shiro.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.chuangbu.common.util.security.Digests;
import com.chuangbu.common.util.security.Encodes;

public class ShiroInit {

	public static Map<String, User> users = new ConcurrentHashMap<String, User>();

	public static Map<String, UserRole> userRoles = new ConcurrentHashMap<String, UserRole>();

	public static Map<String, RolePermission> rolePermissions = new ConcurrentHashMap<String, RolePermission>();

	/** 加密方法 */
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	public static void init() {

		System.out.println("ShiroInit init");
		User user1 = new User(1, "admin", "002", "管理员");
		entryptPassword(user1);

		User user2 = new User(2, "matieli", "001", "马铁利");
		entryptPassword(user2);

		users.put(user1.getLoginName(), user1);
		users.put(user2.getLoginName(), user2);

		Role role1 = new Role(1, "管理员", "manage");
		Role role2 = new Role(2, "员工", "emp");

		UserRole userRole1 = new UserRole(1, user1, role1);
		UserRole userRole2 = new UserRole(2, user2, role2);

		userRoles.put(userRole1.getId() + "", userRole1);
		userRoles.put(userRole2.getId() + "", userRole2);

		Permission permssion1 = new Permission(1, "增加demo", "save_demo");
		Permission permssion2 = new Permission(2, "查询demo", "query_demo");

		RolePermission rolePermission1 = new RolePermission(1, role1, permssion1);
		RolePermission rolePermission2 = new RolePermission(2, role2, permssion2);

		rolePermissions.put(rolePermission1.getId() + "", rolePermission1);
		rolePermissions.put(rolePermission2.getId() + "", rolePermission2);

	}

	public static List<Role> getRoleByUser(User user) {

		UserRole userRole = userRoles.get(user.getId() + "");
		List<Role> roles = new ArrayList<Role>();
		roles.add(userRole.getRole());

		return roles;
	}

	public static List<Permission> getPermissionByRole(Role role) {

		RolePermission rolePermission = rolePermissions.get(role.getId() + "");

		List<Permission> permissions = new ArrayList<Permission>();
		permissions.add(rolePermission.getPermission());

		return permissions;
	}

	private static void entryptPassword(User user) {
		String pass = "123456";
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(pass.getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
}
