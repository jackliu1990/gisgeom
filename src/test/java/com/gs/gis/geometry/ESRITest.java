package com.gs.gis.geometry;

import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;

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
	 }
}
