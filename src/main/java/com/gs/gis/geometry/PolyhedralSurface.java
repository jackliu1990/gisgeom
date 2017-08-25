package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolyhedralSurface extends Surface {

	private final List<Polygon> patchs;

	private static final long serialVersionUID = -4244106348263147023L;

	public PolyhedralSurface() {
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

	@Override
	public Geometry envelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dimension() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is3D() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMeasured() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String asText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] asBinary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Geometry geometry) {
		// TODO Auto-generated method stub
		return false;
	}
}
