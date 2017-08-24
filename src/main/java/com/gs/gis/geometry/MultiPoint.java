package com.gs.gis.geometry;

public class MultiPoint extends GeometryCollection {

	private static final long serialVersionUID = -4206522180686962708L;

	@Override
	public String geometryType() {
		return enumGeomType.MultiPoint.toString();
	}
}
