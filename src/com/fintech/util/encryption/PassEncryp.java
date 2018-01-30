/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 密码加密
 * 类   名  称: Encryp.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2014-1-26
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.encryption;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class PassEncryp {
	
	public static final String VERSION = "@version 1.0.0.1";

	private Cipher cipher;
	private SecretKey deskey;

	public PassEncryp() {

	}

	public PassEncryp(String s) {
		try {
			if (s.length() < 8) {
				s += "        ";
			}
			KeySpec keySpec = new DESKeySpec(s.getBytes());
			deskey = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);
			cipher = Cipher.getInstance(deskey.getAlgorithm());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对字符串加密
	 * 
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] encrytor(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] src = str.getBytes();
		// 加密，结果保存进cipherByte
		return cipher.doFinal(src);
	}

	/**
	 * 对字符串解密
	 * 
	 * @param buff
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] decryptor(byte[] buff) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		return cipher.doFinal(buff);
	}

	/**
	 * 密码加密
	 * 
	 * @param password
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String passEncrytor(String password) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] dst = encrytor(password + "        ");// 密码补足十二位
		String dstStr = "";
		for (int i = 0; i < dst.length && i < 12; i++) {// 密文只取前64位
			int cTmp = (int) dst[i] & 0xff;
			String hexStr = Integer.toHexString(cTmp);
			while (hexStr.length() < 2) {
				hexStr = "0" + hexStr;
			}
			dstStr += hexStr;
		}
		return dstStr.toUpperCase();
	}
}
