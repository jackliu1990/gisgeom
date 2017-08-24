package com.gs.gis.geometry;

import com.fasterxml.jackson.core.JsonProcessingException;
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
     * @throws JsonProcessingException 
     */
    public void testApp() throws JsonProcessingException
    {
        assertTrue( true );
    }
}
