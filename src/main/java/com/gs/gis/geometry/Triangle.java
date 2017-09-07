package com.gs.gis.geometry;

public class Triangle extends Polygon {

	private static final long serialVersionUID = -574969820626952180L;

	public Triangle(){
		
	}
	
	public Triangle(LinearRing exterorRing) {
		super(exterorRing);
	}

	@Override
	public String geometryType() {
		return enumGeomType.Triangle.toString();
	}
}