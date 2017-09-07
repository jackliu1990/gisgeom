package com.gs.gis.geometry;


public class PolyhedralSurface extends Surface {

	private final Polygon[] patchs;

	private static final long serialVersionUID = -4244106348263147023L;

	public PolyhedralSurface() {
		patchs = new Polygon[]{};
	}

	public int numPatches() {
		return patchs.length;
	}

	public Polygon patchN(int index) {
		return patchs[index];
	}

	public MultiPolygon boundingPolygons(Polygon polygon) {
		return null;
	}

	public boolean isClosed() {
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

	@Override
	public int numPoints() {
		int numPoints = 0;
		for (int i = 0; i < numPatches(); i++) {
			numPoints += patchN(i).numPoints();
		}
		return numPoints;
	}
}
