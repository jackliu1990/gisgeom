package com.gs.gis.geometry;

public class Surface extends Geometry {

	private static final long serialVersionUID = -6075485091792226407L;

	protected Surface(int srid) {
	}
	
	public double area() {
		return 0.0F;
	}
	
	public Point centroid() {
		return null;
	}
	
	public Point pointOnSurface() {
		return null;
	}
	
	@Override
	public MultiCurve boundary() {
		return null;
	}

	@Override
	public String geometryType() {
		// TODO Auto-generated method stub
		return null;
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