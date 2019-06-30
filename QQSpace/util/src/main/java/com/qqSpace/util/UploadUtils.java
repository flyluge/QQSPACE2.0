package com.qqSpace.util;

import java.util.UUID;

public class UploadUtils {
	/**
	 * 	根据参数fileName的后缀名生成随机的文件名
	 * @param fileName
	 * @return
	 */
	public static String getUUIDName(String fileName) {
		String uuid=UUID.randomUUID().toString();
		uuid=uuid.replaceAll("-", "");
		// 获取文件名的后缀名
		//获取字符串中 . 的下标
		int index=fileName.indexOf(".");
		fileName=fileName.substring(index);
		return uuid+fileName;
	}
	/**
	 * 	根据文件名随机生成一个文件位置
	 * @param uuidFileName
	 * @return
	 */
	public static String getPath(String uuidFileName) {
		//获取uuidFileName的二进制
		int code1=uuidFileName.hashCode();
		//生成一级目录
		int d1=code1 & 0xf;
		//code1向右移四位作为code2
		int code2=code1 >>> 4;
		//生成二级目录
		int d2=code2 & 0xf;
		return "/"+d1+"/"+d2;
	}
	public static void main(String[] args) {
		String uuid=UploadUtils.getUUIDName("aaa.jpg");
		System.out.println(uuid);
		System.out.println(UploadUtils.getPath(uuid));
	}
}
