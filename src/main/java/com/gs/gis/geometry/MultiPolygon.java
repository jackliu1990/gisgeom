package com.gs.gis.geometry;

public class MultiPolygon extends MultiSurface {

	private static final long serialVersionUID = -8538253533188517173L;

	public MultiPolygon(int srid) {
		super(srid);
	}
	
	@Override
	public String getGeometryType() {
		return enumGeomType.MultiPolygon.toString();
	}
}