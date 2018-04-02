package com.chuangbu.common.util.des3;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3DES加解密工具类
 * @author lixz 
 * @date 2016-03-07
 */
public class Des3Util {
	private static final String CHARSET = "utf-8";
	/**偏移量**/
	private static final String iv = "RCSBLACK";
	/**本类generateKey()方法生成唯一固定秘钥，确保加解密始终可逆**/
	private static final String secretKey = "DC68E0B59E3D1F34B9C152A40BD668131C0BB04FD94902B5";//不可修改！！！

	/**
	 * 3DES加密
	 * @param plainText 普通文本
	 * @param secretKey
	 * @return
	 * @throws Exception 
	 */
	public static String encode(String plainText){
		try{
			Key deskey = null;
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
			byte[] encryptData = cipher.doFinal(plainText.getBytes(CHARSET));
			byte[] bb = Base64.getEncoder().encode(encryptData);
			return new String(bb,CHARSET);
		}catch(Exception e){
			e.printStackTrace();
		}
		return plainText;
	}
	

	/**
	 * 3DES解密
	 * 
	 * @param encryptText 解密文本
	 * @return
	 * @throws Exception
	 */
	public static String decode(String encryptText){
		try{
			Key deskey = null;
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
	
			byte[] decryptData = cipher.doFinal(Base64.getDecoder().decode(encryptText.getBytes(CHARSET)));
			return new String(decryptData, CHARSET);
		}catch(Exception e){
			e.printStackTrace();
		}
		return encryptText;
	}
	
	
	/**
	 * 生成48位3DES密钥
	 * @return
	 */
	public static String generateKey(){
		KeyGenerator kg;
		try {
			kg = KeyGenerator.getInstance("desede");
			kg.init(168);
			SecretKey secretKey = kg.generateKey();
			byte[] key = secretKey.getEncoded();
			return KeyUtil.byte2hex(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

