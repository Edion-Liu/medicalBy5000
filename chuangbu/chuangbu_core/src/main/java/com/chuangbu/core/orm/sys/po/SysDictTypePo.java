package com.chuangbu.core.orm.sys.po;

import com.chuangbu.core.orm.AbstractPo;
/**
 * Description: sys_dict_type Po
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-02-25 21:42:37
 */
public class SysDictTypePo extends AbstractPo{
	// id
	private	String	id;
	// typename
	private	String	typename;
	// typesign
	private	String	typesign;

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * id
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	/**
	 * typename
	 * @return
	 */
	public String getTypename() {
		return typename;
	}

	public void setTypesign(String typesign) {
		this.typesign = typesign;
	}
	/**
	 * typesign
	 * @return
	 */
	public String getTypesign() {
		return typesign;
	}
}