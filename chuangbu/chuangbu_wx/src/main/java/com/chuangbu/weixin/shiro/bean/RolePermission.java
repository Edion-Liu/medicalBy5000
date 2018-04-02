package com.chuangbu.weixin.shiro.bean;

import java.io.Serializable;

public class RolePermission implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Role role;
	private Permission permission;

	public RolePermission() {
	}

	public RolePermission(int id, Role role, Permission permission) {
		super();
		this.id = id;
		this.role = role;
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
