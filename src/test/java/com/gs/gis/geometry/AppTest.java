package com.gs.gis.geometry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.GeometryFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws JsonProcessingException 
     */
    public AppTest( String testName ) throws JsonProcessingException
    {
        super( testName );
        Coordinate a = new Coordinate();
        Point b = new Point(a,3857);
        ObjectMapper mapper = new ObjectMapper();
        String pointGeoJson=mapper.writeValueAsString(b);
        System.out.println(b.getGeometryType());
        System.out.print(pointGeoJson);
        System.out.print(b.getSrid());
       
       /* GeometryFactory geometryFactory = new GeometryFactory();
        com.vividsolutions.jts.geom.Coordinate coord = new com.vividsolutions.jts.geom.Coordinate(109.013388, 32.715519);
        com.vividsolutions.jts.geom.Point point = geometryFactory.createPoint(coord);
        ObjectMapper mapper = new ObjectMapper();
        String pointGeoJson=mapper.writeValueAsString(point);
         System.out.print(pointGeoJson);*/
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
