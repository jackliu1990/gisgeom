package com.gs.gis.io.wkb;

import java.nio.ByteOrder;

import com.gs.gis.geometry.EnumGeomType;
import com.gs.gis.geometry.Geometry;
import com.gs.gis.geometry.Point;

public class WKBReader {
	
	/**
	 * 读取WKB字符为Geometry
	 * @param reader
	 * @return
	 */
	public static Geometry readGeometry(ByteReader reader){
		Geometry geometry = readGeometry(reader,null);
				return geometry;
	}
	
	public static <T extends Geometry> T readGeometry(ByteReader reader,Class<T> expectedType){
	    //读物 字符编码
		byte byteOrderValue = reader.readByte();
	    ByteOrder byteOrder = byteOrderValue == 0?ByteOrder.BIG_ENDIAN:ByteOrder.LITTLE_ENDIAN;
	    ByteOrder originalByteOrder = reader.getByteOrder();
	    reader.setByteOrder(byteOrder);
	    
	    //读取几何Integer类型
	    int geometryTypeWkbCode = reader.ReadInt();
	    
	 // Look at the last 2 digits to find the geometry type code (1 - 14)
	 	int geometryTypeCode = geometryTypeWkbCode % 1000;

	 		// Look at the first digit to find the options (z when 1 or 3, m when 2
	 		// or 3)
	     int geometryTypeMode = geometryTypeWkbCode / 1000;
	     boolean is3D = false;
	     boolean isMeasured = false;
	     switch (geometryTypeMode) {
			case 0:
				break;

			case 1:
				is3D = true;
				break;

			case 2:
				isMeasured = true;
				break;

			case 3:
				is3D = true;
				isMeasured = true;
				break;
			}
	     
	     EnumGeomType geometryType = EnumGeomType.fromWkbType(geometryTypeCode);
	     Geometry geometry = null;
	   
	     switch(geometryType){
	     case Geometry:
	    	 throw new RuntimeException("Unexpected Geometry Type of "
						+ geometryType.name() + " which is abstract");
	     case Point:
				geometry = readPoint(reader, is3D, isMeasured);
				break;
			case LineString:
				geometry = readLineString(reader, is3D, isMeasured);
				break;
			case Polygon:
				geometry = readPolygon(reader, is3D, isMeasured);
				break;
			case MultiPoint:
				geometry = readMultiPoint(reader, is3D, isMeasured);
				break;
			case MultiLineString:
				geometry = readMultiLineString(reader, is3D, isMeasured);
				break;
			case MultiPolygon:
				geometry = readMultiPolygon(reader, is3D, isMeasured);
				break;
			case GeometryCollection:
				geometry = readGeometryCollection(reader, is3D, isMeasured);
				break;
			case MultiCurve:
				throw new RuntimeException("Unexpected Geometry Type of "
						+ geometryType.name() + " which is abstract");
			case MultiSurface:
				throw new RuntimeException("Unexpected Geometry Type of "
						+ geometryType.name() + " which is abstract");
			case Curve:
				throw new RuntimeException("Unexpected Geometry Type of "
						+ geometryType.name() + " which is abstract");
			case Surface:
				throw new RuntimeException("Unexpected Geometry Type of "
						+ geometryType.name() + " which is abstract");
			case PolyhedralSurface:
				geometry = readPolyhedralSurface(reader, is3D, isMeasured);
				break;
			case TIN:
				geometry = readTIN(reader, is3D, isMeasured);
				break;
			case Triangle:
				geometry = readTriangle(reader, is3D, isMeasured);
				break;
			default:
				throw new RuntimeException("Geometry Type not supported: "
						+ geometryType);
	     }
	     
	  // If there is an expected type, verify the geometry if of that type
			if (expectedType != null && geometry != null
					&& !expectedType.isAssignableFrom(geometry.getClass())) {
				throw new RuntimeException("Unexpected Geometry Type. Expected: "
						+ expectedType.getSimpleName() + ", Actual: "
						+ geometry.getClass().getSimpleName());
			}

			// Restore the byte order
			reader.setByteOrder(originalByteOrder);

			@SuppressWarnings("unchecked")
			T result = (T) geometry;
			
			return result;
	     
	}

	private static Geometry readTriangle(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readTIN(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readPolyhedralSurface(ByteReader reader,
			boolean is3d, boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readGeometryCollection(ByteReader reader,
			boolean is3d, boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readMultiPolygon(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readMultiLineString(ByteReader reader,
			boolean is3d, boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readMultiPoint(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readPolygon(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readLineString(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Geometry readPoint(ByteReader reader, boolean is3d,
			boolean isMeasured) {
		double x = reader.readDouble();
		double y = reader.readDouble();
		Point point = new Point(x, y);
		if (is3d) {
			double z = reader.readDouble();
			point.setZ(z);
		}

		if (isMeasured) {
			double m = reader.readDouble();
			point.setM(m);
		}

		return point;
	}
}
