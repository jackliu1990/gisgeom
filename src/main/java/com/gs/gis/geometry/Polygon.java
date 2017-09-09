package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Surface {

	private static final long serialVersionUID = -365994711439639146L;
	private LinearRing exterorRing;
	private List<LinearRing> interiorRings;

	public Polygon() {

	}

	public Polygon(LinearRing exterorRing) {
		this.exterorRing = exterorRing;
		interiorRings = new ArrayList<LinearRing>();
	}

	public Polygon(LinearRing exterorRing, List<LinearRing> interiorRings) {
		if (exterorRing == null) {
			exterorRing = new LinearRing();
		}
		if (interiorRings == null) {
			interiorRings = new ArrayList<LinearRing>();
		}
		if (hasNullElements(interiorRings.toArray())) {
			throw new IllegalArgumentException(
					"interiorRings must not contain null elements");
		}
		if (exterorRing.isEmpty() && hasNonEmptyElements(interiorRings.toArray(new LinearRing[] {}))) {
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
		return interiorRings.size();
	}

	public void addInteriorRing(LinearRing interiorRing) {
		interiorRings.add(interiorRing);
	}

	public LinearRing interiorRingN(int index) {
		return interiorRings.get(index);
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
	    for (int i = 0; i < this.numInteriorRings(); i++) {
	      numPoints += this.interiorRingN(i).numPoints();
	    }
	    return numPoints;
	  }

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point centroid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point pointOnSurface() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MultiCurve<Curve> boundary() {
		// TODO Auto-generated method stub
		return null;
	}
}
