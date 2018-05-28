package com.web.shorturl.util;

public class CryptUtil {

	static final char[] CharData = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
	
	public static String encrypt(long seqNo){
		
		StringBuffer sb = new StringBuffer();
		while(seqNo>0){		
			int i = (int) (seqNo % CharData.length);
			sb.append(CharData[i]);
			seqNo = seqNo / CharData.length;
		}
		
		return sb.toString();
	}
	
	public static long decrypt(String context){
		long result = 0;
		
		for(int i=0; i<context.length(); i++){
			int digit = new String(CharData).indexOf(context.charAt(i));
			result = result + (long) ( digit *Math.pow(CharData.length, i));
		}
	
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt(20180527000016L));		
		System.out.println(decrypt("AGry6RtF") );
	}
}
