package com.gs.gis.geometry;

public class MultiPolygon extends MultiSurface {

	private static final long serialVersionUID = -8538253533188517173L;
	
	@Override
	public String geometryType() {
		return enumGeomType.MultiPolygon.toString();
	}
}