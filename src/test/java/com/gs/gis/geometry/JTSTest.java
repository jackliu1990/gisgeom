package com.gs.gis.geometry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

public class JTSTest {
	 public static void main(String[] args) throws ParseException, JsonProcessingException {  
  
     GeometryFactory geometryFactory = new GeometryFactory();
     com.vividsolutions.jts.geom.Coordinate coord = new com.vividsolutions.jts.geom.Coordinate(109.013388, 32.715519,133);
     com.vividsolutions.jts.geom.Point point = geometryFactory.createPoint(coord);
     // ObjectMapper mapper = new ObjectMapper();
      //String pointGeoJson=mapper.writeValueAsString(point);
     //System.out.print(pointGeoJson);
     
      WKTReader reader = new WKTReader( geometryFactory );  
      com.vividsolutions.jts.geom.Point point2 = ( com.vividsolutions.jts.geom.Point) reader.read("POINT Z(1 1 5)");  
      System.out.print(point2.getCoordinate().z);
      
      WKTWriter writer = new WKTWriter(3);
      System.out.println(writer.write(point));
	 }
}
