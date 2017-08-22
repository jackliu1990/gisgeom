package com.gs.gis.geometry;

public class MultiPoint extends GeometryCollection {

	private static final long serialVersionUID = -4206522180686962708L;

	public MultiPoint(int srid) {
		super(srid);
	}

	@Override
	public String getGeometryType() {
		return enumGeomType.MultiPoint.toString();
	}
}
