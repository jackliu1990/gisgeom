package com.gs.gis.io.wkb;

import java.io.IOException;
import java.nio.ByteOrder;

import com.gs.gis.geometry.EnumGeomType;
import com.gs.gis.geometry.Geometry;
import com.gs.gis.geometry.GeometryCollection;
import com.gs.gis.geometry.LineString;
import com.gs.gis.geometry.MultiLineString;
import com.gs.gis.geometry.MultiPoint;
import com.gs.gis.geometry.MultiPolygon;
import com.gs.gis.geometry.Point;
import com.gs.gis.geometry.Polygon;
import com.gs.gis.geometry.PolyhedralSurface;
import com.gs.gis.geometry.TIN;
import com.gs.gis.geometry.Triangle;

public class WKBWriter {
	public static void writeGeometry(ByteWriter writer, Geometry geometry) throws IOException {
		// 写入byte order type
		byte byteOrder = writer.getByteOrder() == ByteOrder.BIG_ENDIAN ? (byte) 0 : (byte) 1;
		writer.writeByte(byteOrder);

		// 写入Geometry type integer

		writer.writeInt(geometry.typeWKB());
		EnumGeomType geomType = geometry.geometryType();

		switch (geomType) {
		case Geometry:
			throw new RuntimeException("Unexpected Geometry Type of " + geomType.name() + " which is abstract");
		case Point:
			writePoint(writer, (Point) geometry);
			break;
		case LineString:
			writeLineString(writer, (LineString) geometry);
			break;
		case Polygon:
			writePolygon(writer, (Polygon) geometry);
			break;
		case MultiPoint:
			writeMultiPoint(writer, (MultiPoint) geometry);
			break;
		case MultiLineString:
			writeMultiLineString(writer, (MultiLineString) geometry);
			break;
		case MultiPolygon:
			writeMultiPolygon(writer, (MultiPolygon) geometry);
			break;
		case GeometryCollection:
			WriteGeometryCollection(writer, (GeometryCollection<?>) geometry);
			break;
		case MultiCurve:
			throw new RuntimeException("Unexpected Geometry Type of " + geomType.name() + " which is abstract");
		case MultiSurface:
			throw new RuntimeException("Unexpected Geometry Type of " + geomType.name() + " which is abstract");
		case Curve:
			throw new RuntimeException("Unexpected Geometry Type of " + geomType.name() + " which is abstract");
		case Surface:
			throw new RuntimeException("Unexpected Geometry Type of " + geomType.name() + " which is abstract");
		case PolyhedralSurface:
			writePolyhedralSurface(writer, (PolyhedralSurface) geometry);
			break;
		case TIN:
			writeTIN(writer, (TIN) geometry);
			break;
		case Triangle:
			writeTriangle(writer, (Triangle) geometry);
			break;
		default:
			throw new RuntimeException("Geometry Type not supported" + geomType);
		}
	}

	private static void writeTriangle(ByteWriter writer, Triangle geometry) {
		// TODO Auto-generated method stub

	}

	private static void writeTIN(ByteWriter writer, TIN geometry) {
		// TODO Auto-generated method stub

	}

	private static void writePolyhedralSurface(ByteWriter writer, PolyhedralSurface geometry) {
		// TODO Auto-generated method stub

	}

	private static void WriteGeometryCollection(ByteWriter writer, GeometryCollection<?> geometry) {
		// TODO Auto-generated method stub

	}

	private static void writeMultiPolygon(ByteWriter writer, MultiPolygon geometry) {
		// TODO Auto-generated method stub

	}

	private static void writeMultiLineString(ByteWriter writer, MultiLineString geometry) {
		// TODO Auto-generated method stub

	}

	private static void writeMultiPoint(ByteWriter writer, MultiPoint geometry) {
		// TODO Auto-generated method stub

	}

	private static void writePolygon(ByteWriter writer, Polygon geometry) {
		// TODO Auto-generated method stub

	}

	private static void writeLineString(ByteWriter writer, LineString lineString) throws IOException {
	     writer.writeInt(lineString.numPoints());
	     for(int i=0;i<lineString.numPoints();i++) {
	    	 writePoint(writer,lineString.pointN(i));
	     }

	}

	private static void writePoint(ByteWriter writer, Point point) throws IOException {
		writer.writeDouble(point.X());
		writer.writeDouble(point.Y());
		if(point.is3D()) {
			writer.writeDouble(point.Z());
		}
		if(point.isMeasured()) {
			writer.writeDouble(point.M());
		}

	}
}
