package com.chuangbu.cgm.db;

import java.util.List;

import com.chuangbu.cgm.exception.CodegenException;
import com.chuangbu.cgm.model.TableModel;

public interface IDbHelper {
	void setUrl(String url, String username, String password);
	TableModel getByTable(String tableName) throws CodegenException;
	List<String> getAllTable() throws CodegenException;
}
