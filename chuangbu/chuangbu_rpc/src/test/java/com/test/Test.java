package com.test;

import com.chuangbu.rpc.client.Client;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年4月7日 下午10:52:28
 */

public class Test {
	private static final String docterInp = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
			.append("<Request>").append("    <DealType>0200</DealType>").append("    <DealCode>100206</DealCode>")
			.append("    <Body>").append("        <DeptCode>%s</DeptCode>").append("    </Body>")
			.append("</Request>").toString();

	public static void main(String[] args) {
		/*String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
        		"<Request>"+
        		"    <DealType>0200</DealType>"+
        		"    <DealCode>100204</DealCode>"+
        		"    <Body>"+
        		"        <SpecialType>-1</SpecialType>"+
        		"    </Body>"+
        		"</Request>";
		
		System.out.println(Client.mzghService(str));*/
		String docterStr = String.format(docterInp, "20112");
		String result = Client.mzghService(docterStr);
		System.out.println(result);
	}

}
