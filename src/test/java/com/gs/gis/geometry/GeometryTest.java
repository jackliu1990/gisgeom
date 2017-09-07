package com.gs.gis.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs.gis.referenceSystems.SpatialReferenceSystem;

public class GeometryTest {

	@Test
	public void CreatePoint() throws JsonProcessingException {
		SpatialReferenceSystem spatialReference = new SpatialReferenceSystem(4326);
		Point point = new Point(116,40);
		point.setSpatialReference(spatialReference);
		System.out.print(new ObjectMapper().writeValueAsString(point));
	}
}
