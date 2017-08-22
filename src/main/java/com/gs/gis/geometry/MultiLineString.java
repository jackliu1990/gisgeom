package com.gs.gis.geometry;

public class MultiLineString extends MultiCurve {

	private static final long serialVersionUID = 8789353483850475564L;

	public MultiLineString(int srid) {
		super(srid);
	}
	
	@Override
	public String getGeometryType() {
		return enumGeomType.MultiLineString.toString();
	}
}
