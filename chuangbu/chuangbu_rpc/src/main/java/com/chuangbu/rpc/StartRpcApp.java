package com.chuangbu.rpc;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.chuangbu.common.util.des3.Des3Util;

/**   
* @Title: StartRpcApp.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月2日 下午5:24:20 
* @version V1.0   
*/
@SpringBootApplication
@ComponentScan
public class StartRpcApp {
	public static void main(String ...s){
        SpringApplication.run(StartRpcApp.class, s);
    }
	
	  @Autowired
	    private Environment env;

	    @Bean
	    public DataSource dataSource() {
	    	String isEncry = env.getProperty("datasource.isEncry");
	    	String username = env.getProperty("spring.datasource.username");
	    	String password = env.getProperty("spring.datasource.password");
	    	if(StringUtils.isNotBlank(isEncry) && isEncry.equals("true")){
	    		username = Des3Util.decode(username);
	    		password = Des3Util.decode(password);
	    	}
	        DruidDataSource dataSource = new DruidDataSource();
	        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	        dataSource.setUrl(env.getProperty("spring.datasource.url"));
	        dataSource.setUsername(username);//用户名
	        dataSource.setPassword(password);//密码
	        dataSource.setInitialSize(2);
	        dataSource.setMaxActive(20);
	        dataSource.setMinIdle(0);
	        dataSource.setMaxWait(60000);
	        dataSource.setValidationQuery("SELECT 1");
	        dataSource.setTestOnBorrow(false);
	        dataSource.setTestWhileIdle(true);
	        dataSource.setPoolPreparedStatements(false);
	        return dataSource;
	    }
}
