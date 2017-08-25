package com.gs.gis.geometry;

public class TIN extends PolyhedralSurface {

	private static final long serialVersionUID = -8870541462672402111L;

	public TIN() {
	}
	
	@Override
	public String geometryType() {
		return enumGeomType.TIN.toString();
	}
}