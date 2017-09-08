package com.gs.gis.io.wkb;

import java.io.IOException;
import java.nio.ByteOrder;

import com.gs.gis.geometry.Geometry;

public class WKBWriter {
	public static void writeGeometry(ByteWriter writer,Geometry geometry) throws IOException{
       //写入byte order type
		byte byteOrder = writer.getByteOrder() ==ByteOrder.BIG_ENDIAN?(byte)0:(byte)1;
		writer.writeByte(byteOrder);
		
		//写入Geometry type integer
		
		writer.writeInt(geometry.geometryType());
	}
}
