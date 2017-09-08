package com.gs.gis.geometry;

public class TIN extends PolyhedralSurface {

	private static final long serialVersionUID = -8870541462672402111L;

	public TIN() {
	}
	
	@Override
	public EnumGeomType geometryType() {
		return EnumGeomType.TIN;
	}
}