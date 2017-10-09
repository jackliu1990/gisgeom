package com.gs.gis.geometry;

import com.esri.core.geometry.MultiPath;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.geometry.ogc.OGCGeometry;
import com.esri.core.geometry.ogc.OGCPolygon;

public class ESRITest {

	 public static void main(String[] args) {   
	   SpatialReference sr = null;
	   Point pt =new Point(1,2,3);
	   pt.setM(2.8);
	   com.esri.core.geometry.ogc.OGCPoint point = new com.esri.core.geometry.ogc.OGCPoint(pt , sr) ;
	   
	   Point pt1 =new Point(1,2,3);
	   pt1.setM(2.8);
	   com.esri.core.geometry.ogc.OGCPoint point1 = new com.esri.core.geometry.ogc.OGCPoint(pt1 , sr) ;
	   
	   com.esri.core.geometry.MultiPoint multiPoint = new  com.esri.core.geometry.MultiPoint();
	   multiPoint.add(pt);
	   multiPoint.add(pt1);
	   com.esri.core.geometry.ogc.OGCMultiPoint ogcMultiPoint = new com.esri.core.geometry.ogc.OGCMultiPoint(multiPoint,sr);
	   System.out.println(point.asText());
	   
		OGCGeometry g = OGCGeometry
				.fromText("Polygon((-5 -5, -5 5, 5 5, 5 -5, -5 -5),(-5 -5, -5 5, 5 5, 5 -5, -5 -5))");
		OGCPolygon p = (OGCPolygon) g;
		System.out.println(p.exteriorRing().asText());
		
	 }
}
