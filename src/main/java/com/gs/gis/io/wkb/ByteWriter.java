package com.gs.gis.io.wkb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteWriter {
	
	/**
	 * 输出字符流对象
	 */
	private final ByteArrayOutputStream os = new ByteArrayOutputStream();

	/**
	 * 字符编码方式：大尾端即大端高位优先存储，小尾端即小端低位优先存储
	 */
	private ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
	
	
	/**
	 * 构造函数
	 */
	public ByteWriter(){}
	
	public void close(){
		try{
		   os.close();	
		}catch(IOException e){
			
		}
	}
	
	
	public ByteOrder getByteOrder(){
		return byteOrder;
	}
	
	public void setByteOrder(ByteOrder byteOrder){
		this.byteOrder = byteOrder;
	}
	
	public byte[] getBytes(){
		return os.toByteArray();
	}
	
	public int size(){
		return os.size();
	}
	
	public void writeString(String value)throws IOException{
		byte[] valueBytes = value.getBytes();
		os.write(valueBytes);
	}
	
	public void writeByte(byte value){
		os.write(value);
	}
	
	public void writeInt(int value) throws IOException{
		byte[] valueBytes = new byte[4];
		ByteBuffer byteBuffer = ByteBuffer.allocate(4).order(byteOrder).putInt(value);
		byteBuffer.flip();
		byteBuffer.get(valueBytes);
		os.write(valueBytes);
	}
	
	public void writeDouble(double value) throws IOException{
		byte[] valueBytes = new byte[8];
		ByteBuffer byteBuffer = ByteBuffer.allocate(8).order(byteOrder).putDouble(value);
		byteBuffer.flip();
		byteBuffer.get(valueBytes);
		os.write(valueBytes);
	}
	
}
