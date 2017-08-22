package com.gs.gis.geometry;

public class Triangle extends Polygon {

	private static final long serialVersionUID = -574969820626952180L;

	public Triangle(LinearRing exterorRing, int srid) {
		super(exterorRing, srid);
	}

	@Override
	public String getGeometryType() {
		return enumGeomType.Triangle.toString();
	}
}