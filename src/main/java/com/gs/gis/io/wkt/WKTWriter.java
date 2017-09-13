package com.gs.gis.io.wkt;

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

public class WKTWriter {
	public static String writeGeometry(Geometry geometry){
		StringBuilder builder = new StringBuilder();
		EnumGeomType geomType = geometry.geometryType();
		builder.append(geomType.typeWKT());
		if(geometry.isEmpty()){
			builder.append(" ").append("EMPTY");
		    return builder.toString();
		}
		else if(geometry.is3D()&&geometry.isMeasured()){
			builder.append(" ").append("ZM");
			builder.append(" ").append("(");
			builder.append(writeGeometryContent(geometry));
			builder.append(")");
			return builder.toString();
		}
		else if(geometry.is3D()){
			builder.append(" ").append("Z");
			builder.append(" ").append("(");
			builder.append(writeGeometryContent(geometry));
			builder.append(")");
			return builder.toString();
		}
		else if(geometry.isMeasured()){
			builder.append(" ").append("M");
			builder.append(" ").append("(");
			builder.append(writeGeometryContent(geometry));
			builder.append(")");
			return builder.toString();
		}
		return builder.toString();
	
	}
	
	
	
	private static void writeTriangle(Triangle geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writeTIN(TIN geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writePolyhedralSurface(PolyhedralSurface geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void WriteGeometryCollection(GeometryCollection<?> geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writeMultiPolygon(MultiPolygon geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writeMultiLineString(MultiLineString geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writeMultiPoint(MultiPoint geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writePolygon(Polygon geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writeLineString(LineString geometry, StringBuilder builder) {
		// TODO Auto-generated method stub
		
	}



	private static void writePoint(Point point, StringBuilder builder) {
		 
		
	}



	private static String writeGeometryContent(Geometry geometry){
		StringBuilder builder = new StringBuilder();
		EnumGeomType geomType = geometry.geometryType();
		switch (geomType) {
		case Geometry:
			throw new RuntimeException("Unexpected Geometry Type of "
					+ geomType.name() + " which is abstract");
		case Point:
			writePoint((Point) geometry,builder);
			break;
		case LineString:
			writeLineString((LineString) geometry,builder);
			break;
		case Polygon:
			writePolygon((Polygon) geometry,builder);
			break;
		case MultiPoint:
			writeMultiPoint((MultiPoint) geometry,builder);
			break;
		case MultiLineString:
			writeMultiLineString((MultiLineString) geometry,builder);
			break;
		case MultiPolygon:
			writeMultiPolygon((MultiPolygon) geometry,builder);
			break;
		case GeometryCollection:
			WriteGeometryCollection((GeometryCollection<?>) geometry,builder);
			break;
		case MultiCurve:
			throw new RuntimeException("Unexpected Geometry Type of "
					+ geomType.name() + " which is abstract");
		case MultiSurface:
			throw new RuntimeException("Unexpected Geometry Type of "
					+ geomType.name() + " which is abstract");
		case Curve:
			throw new RuntimeException("Unexpected Geometry Type of "
					+ geomType.name() + " which is abstract");
		case Surface:
			throw new RuntimeException("Unexpected Geometry Type of "
					+ geomType.name() + " which is abstract");
		case PolyhedralSurface:
			writePolyhedralSurface((PolyhedralSurface) geometry,builder);
			break;
		case TIN:
			writeTIN((TIN) geometry,builder);
			break;
		case Triangle:
			writeTriangle((Triangle) geometry,builder);
			break;
		default:
			throw new RuntimeException("Geometry Type not supported" + geomType);
		}
		return builder.toString();
		
	}
	
}
