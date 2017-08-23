package com.gs.gis.geometry;

import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;

public class ESRITest {

	 public static void main(String[] args) {   
	   SpatialReference sr = null;
	   Point pt =new Point(1,2,3);
	   pt.setM(2.8);
	   com.esri.core.geometry.ogc.OGCPoint point = new com.esri.core.geometry.ogc.OGCPoint(pt , sr) ;
	   System.out.println(point.asText());
	 }
}
