package com.gs.gis.geometry;

import java.io.IOException;
import java.nio.ByteOrder;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs.gis.io.wkb.ByteWriter;
import com.gs.gis.io.wkb.WKBWriter;
import com.gs.gis.referenceSystems.SpatialReferenceSystem;
import com.vividsolutions.jts.geom.GeometryFactory;

public class GeometryTest {

	@Test
	public void CreatePoint() throws IOException {
		SpatialReferenceSystem spatialReference = new SpatialReferenceSystem(4326);
		Point point = new Point(116.0,40.0,2345.0);
		point.setSpatialReference(spatialReference);
		System.out.print(new ObjectMapper().writeValueAsString(point));
		
		
		MultiPoint multiPoint = new MultiPoint();
		multiPoint.addGeometry(point);
		System.out.print(multiPoint.geometryType().typeWKB());
		System.out.print(point.geometryType().typeWKB());
		System.out.println(multiPoint.geometryType());
		
		ByteWriter byteWriter = new ByteWriter();
        byteWriter.setByteOrder(ByteOrder.LITTLE_ENDIAN);
		WKBWriter.writeGeometry(byteWriter, point);
		byte[] bytes=byteWriter.getBytes();
		System.out.println(bytes);
			

		  
	     GeometryFactory geometryFactory = new GeometryFactory();
	     com.vividsolutions.jts.geom.Coordinate coord = new com.vividsolutions.jts.geom.Coordinate(116.0,40.0);
	     com.vividsolutions.jts.geom.Point pointJTS = geometryFactory.createPoint(coord);
	     com.vividsolutions.jts.io.WKBWriter wkbwriterJts= new  com.vividsolutions.jts.io.WKBWriter(3);
	     byte[] jtsWkb= wkbwriterJts.write(pointJTS);
	 	 System.out.println(jtsWkb);
	 	 
	 	 com.esri.core.geometry.Point ersiPoint = new  com.esri.core.geometry.Point();
	 	ersiPoint.setXY(116.0, 40.0);
	 	ersiPoint.setZ(2345.0);
	 	 com.esri.core.geometry.ogc.OGCPoint ogcPoint = new  com.esri.core.geometry.ogc.OGCPoint(ersiPoint, null);
	 	byte[] ersiBytes= ogcPoint.asBinary().array();
	 	System.out.println(ersiBytes);
	 	/*for(int i=0;i<ersiBytes.length;i++) {
	 		if(bytes[i]!=ersiBytes[i]) {
	 			System.out.println(true);
	 		}
	 		System.out.println(false);
	 	}*/
	 	
	 	mil.nga.wkb.geom.Point ngaPoint = new mil.nga.wkb.geom.Point(false,false,116.0,40.0);
	 	ngaPoint.setZ(2345.0);
	 	mil.nga.wkb.io.ByteWriter ngaByteWriter = new mil.nga.wkb.io.ByteWriter();
	 	ngaByteWriter.setByteOrder(ByteOrder.LITTLE_ENDIAN);
	 	mil.nga.wkb.io.WkbGeometryWriter.writeGeometry(ngaByteWriter,ngaPoint);
	 	System.out.println(ngaByteWriter.getBytes());
	 	
	 	for(int i=0;i<ngaByteWriter.getBytes().length;i++) {
 		if(ngaByteWriter.getBytes()[i]!=jtsWkb[i]) {
 			System.out.println(true);
 		}
 		System.out.println(false);
	 	}
	}
}
