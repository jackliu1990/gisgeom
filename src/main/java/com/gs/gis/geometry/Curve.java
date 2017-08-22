package com.gs.gis.geometry;

public class Curve extends Geometry {
	private static final long serialVersionUID = -5925605665311300225L;

	protected Curve(int srid) {
		super(srid);
	}

	public double getLength() {
		return 0.0F;
	}

	public Point startPoint() {
		return null;
	}

	public Point endPoint() {
		return null;
	}

	public boolean isClosed() {
		return false;
	}

	public boolean isRing() {
		return false;
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
		return 1;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean is3D() {
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
