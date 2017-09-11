package com.gs.gis.io.wkb;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteReader {
	/**
	 * 字符编码
	 */
	private static final String CHAR_SET = "UTF-8";
	
	/**
	 * 下一个读取字符
	 */
	private int nextByte = 0;
	
	/**
	 * 读取的字符数组
	 */
	private final byte[] bytes;
	
	/**
	 * 字符编码方式
	 */
	private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
	
	/**
	 * Constructor
	 * @param bytes
	 */
	public ByteReader(byte[] bytes){
		this.bytes = bytes;
	}
	
	/**
	 * 获取下一个读取的字符
	 * @return 下一个读取字符
	 */
	public int getNextByte(){
		return nextByte;
	}
	
	/**
	 * 获取字符编码方式
	 * @return 字符编码方式
	 */
	public ByteOrder getByteOrder(){
		return byteOrder;
	}
	
	/**
	 * 设置字符编码方式
	 * @param byteOrder 字符编码方式
	 */
	public void setByteOrder(ByteOrder byteOrder){
		this.byteOrder = byteOrder;
	}
	
	/**
	 * 读取字符串
	 * @param num 字符数量
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String readString(int num) throws UnsupportedEncodingException{
		verifyRemainingBytes(num);
		String value = new String(bytes,nextByte,num,CHAR_SET);
		nextByte+= num;
		return value;
	}
	
	/**
	 * 读取字符
	 * @return 字符
	 */
	public byte readByte(){
		verifyRemainingBytes(1);
		byte value = bytes[nextByte];
		nextByte++;
		return value;
	}
	
	/**
	 * 读取整型
	 * @return 整型值
	 */
	public int ReadInt(){
		verifyRemainingBytes(4);
		int value = ByteBuffer.wrap(bytes, nextByte, 4).order(byteOrder)
				.getInt();
		nextByte += 4;
		return value;
	}
	
	
	/**
	 * 读取双精度
	 * 
	 * @return 双精度
	 */
	public double readDouble() {
		verifyRemainingBytes(8);
		double value = ByteBuffer.wrap(bytes, nextByte, 8).order(byteOrder)
				.getDouble();
		nextByte += 8;
		return value;
	}
	
	
	
	/**
	 * 验证剩余的字符是否有足够的长度去读取。
	 * 
	 * @param bytesToRead 读取字符的数量
	 *        
	 */
	private void verifyRemainingBytes(int bytesToRead) {
		if (nextByte + bytesToRead > bytes.length) {
			throw new RuntimeException(
					"No more remaining bytes to read. Total Bytes: "
							+ bytes.length + ", Bytes already read: "
							+ nextByte + ", Attempted to read: " + bytesToRead);
		}
	}
	
}