package com.test.des;

import com.chuangbu.common.util.des3.Des3Util;

/**   
* @Title: DesTest.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月24日 下午2:37:09 
* @version V1.0   
*/
public class DesTest {
	public static void main(String[] args) {
		String str = "hlx/nk3h0ZqM8ejGSZvRkuqaJjGaIRq9cFhjVJUHlbqlcjqwiyvxmOjWjeREZ1lM2dzUrTLYcLGIMfNjRqQ1iyU0m9NGgPNt/N8BV0+4W3ED8fK3La6aZZMhwgnk5NDnVRQsOEgsr6gAdgxqSiCxcIPhk14xWlNSycqkSzTW9TM=";
		System.out.println(Des3Util.decode(str));
	}
}
