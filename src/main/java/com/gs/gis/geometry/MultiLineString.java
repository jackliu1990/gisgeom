package com.gs.gis.geometry;

public class MultiLineString extends MultiCurve {

	private static final long serialVersionUID = 8789353483850475564L;

	@Override
	public String geometryType() {
		return enumGeomType.MultiLineString.toString();
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean length() {
		// TODO Auto-generated method stub
		return false;
	}
}
