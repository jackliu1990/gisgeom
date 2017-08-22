package com.gs.gis.geometry;

public class Surface extends Geometry {

	private static final long serialVersionUID = -6075485091792226407L;

	protected Surface(int srid) {
		super(srid);
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
	
	public MultiCurve boundary() {
		return null;
	}

	@Override
	public String getGeometryType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Geometry getEnvelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDimension() {
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
	public Coordinate getCoordinate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordinate[] getCoordinates() {
		// TODO Auto-generated method stub
		return null;
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
}