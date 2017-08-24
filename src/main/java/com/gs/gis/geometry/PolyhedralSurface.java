package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyhedralSurface extends Surface {

	private final List<Polygon> patchs;

	private static final long serialVersionUID = -4244106348263147023L;

	public PolyhedralSurface(int srid) {
		super(srid);
		patchs = new ArrayList<Polygon>();
	}

	public int numPatches() {
		return patchs.size();
	}

	public Polygon patchN(int index) {
		return patchs.get(index);
	}

	public MultiPolygon boundingPolygons(Polygon polygon) {
		return null;
	}
	
	public boolean isClosed(){
		return true;
	}

	@Override
	public String geometryType() {
		return enumGeomType.PolyhedralSurface.toString();
	}
}
