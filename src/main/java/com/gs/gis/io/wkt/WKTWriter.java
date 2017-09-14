package com.gs.gis.io.wkt;

import java.util.List;

import com.gs.gis.geometry.EnumGeomType;
import com.gs.gis.geometry.Geometry;
import com.gs.gis.geometry.GeometryCollection;
import com.gs.gis.geometry.LineString;
import com.gs.gis.geometry.LinearRing;
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
		else{
			builder.append(" ").append("(");
			builder.append(writeGeometryContent(geometry));
			builder.append(")");
			return builder.toString();
		}
	
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



	private static void WriteGeometryCollection(GeometryCollection<?> geometryCollection, StringBuilder builder) {
		 int size = geometryCollection.numGeometries();
		 for(int i=0;i<size;i++){
			 Geometry geometry = geometryCollection.geometryN(i);
			 builder.append(writeGeometry(geometry)+", ");
		 }
		 builder.deleteCharAt(builder.length()-1);
	}



	private static void writeMultiPolygon(MultiPolygon geometry, StringBuilder builder) {
		writeGC(geometry, builder);
	}



	private static void writeMultiLineString(MultiLineString geometry, StringBuilder builder) {
		writeGC(geometry, builder);
	}



	private static void writeMultiPoint(MultiPoint multiPoint, StringBuilder builder) {
		writeGC(multiPoint,builder);
	}


	
	private static void writeLinearRing(LinearRing linearRing,StringBuilder builder){
		builder.append("(");
		writeLineString(linearRing,builder);
		builder.append("),");
	}

	private static void writePolygon(Polygon polygon, StringBuilder builder) {
		LinearRing exterorRing = polygon.exterorRing();
		writeLinearRing(exterorRing,builder);
		int size = polygon.numInteriorRings();
		for(int i=0;i<size;i++){
			LinearRing interiorRing = polygon.interiorRingN(i);
			writeLinearRing(interiorRing,builder);
		}
		builder.deleteCharAt(builder.length()-1);
	}



	private static void writeLineString(LineString lineString, StringBuilder builder) {
		writePoints(lineString.getPoints(),builder);
	}
	
	private static void writeGC(GeometryCollection<?> geometryCollection,StringBuilder builder){
		int size = geometryCollection.numGeometries();
		for(int i=0;i<size;i++){
			Geometry geometry = geometryCollection.geometryN(i);
			builder.append("(");
			builder.append(writeGeometryContent(geometry));
			builder.append("),");
		}
	    builder.deleteCharAt(builder.length()-1);
	}
	
	private static void writePoints(List<Point> points,StringBuilder builder){
	   StringBuilder pointsBuilder = new StringBuilder();
	   for(int i=0;i<points.size();i++){
		   Point point = points.get(i);
		   writePoint(point,pointsBuilder);
		   pointsBuilder.append(",");
	   }
	   builder.append(pointsBuilder.substring(1, pointsBuilder.length() - 1));
	}

	private static void writePoint(Point point, StringBuilder builder) {
	    builder.append(point.getX());
	    builder.append(" ").append(point.getY());
	    if(point.is3D()){
	    	builder.append(" ").append(point.getZ());
	    }
	    if(point.isMeasured()){
	    	builder.append(" ").append(point.getM());
	    }
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
		case LinearRing:
			writeLineString((LineString) geometry,builder);
			break;
		case Line:
			writeLineString((LineString) geometry,builder);
			break;
		default:
			throw new RuntimeException("Geometry Type not supported" + geomType);
		}
		return builder.toString();
		
	}
	
}
