package com.gs.gis.geometry;

public class Polygon extends Surface {

	private static final long serialVersionUID = -365994711439639146L;
	private LinearRing exterorRing;
	private LinearRing[] interiorRings;

	public Polygon() {

	}

	public Polygon(LinearRing exterorRing) {
		this.exterorRing = exterorRing;
		interiorRings = new LinearRing[] {};
	}

	public Polygon(LinearRing exterorRing, LinearRing[] interiorRings) {
		if (exterorRing == null) {
			exterorRing = new LinearRing();
		}
		if (interiorRings == null) {
			interiorRings = new LinearRing[] {};
		}
		if (hasNullElements(interiorRings)) {
			throw new IllegalArgumentException(
					"interiorRings must not contain null elements");
		}
		if (exterorRing.isEmpty() && hasNonEmptyElements(interiorRings)) {
			throw new IllegalArgumentException(
					"exterorRing is empty but interiorRings are not");
		}
		this.exterorRing = exterorRing;
		this.interiorRings = interiorRings;
	}

	@Override
	public int dimension() {
		return 2;
	}

	@Override
	public EnumGeomType geometryType() {
		return EnumGeomType.Polygon;
	}

	public LinearRing exterorRing() {
		return exterorRing;
	}

	public int numInteriorRings() {
		return interiorRings.length;
	}

	public void addInteriorRing(LinearRing interiorRing) {
		int index = interiorRings.length + 1;
		interiorRings[index] = interiorRing;
	}

	public LinearRing interiorRingN(int index) {
		return interiorRings[index];
	}

	@Override
	public Geometry envelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return exterorRing.isEmpty();
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
	    int numPoints = exterorRing.numPoints();
	    for (int i = 0; i < interiorRings.length; i++) {
	      numPoints += interiorRings[i].numPoints();
	    }
	    return numPoints;
	  }

}
