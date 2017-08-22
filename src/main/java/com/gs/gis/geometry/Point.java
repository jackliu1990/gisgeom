package com.gs.gis.geometry;


public class Point extends Geometry {
	private static final long serialVersionUID = -5746654819330036683L;
	private Coordinate coordinate;

	public Point(Coordinate coordinate, int srid) {
		super(srid);
		this.coordinate = coordinate;
	}
	
	public double getX() {
		if (coordinate == null) {
			throw new IllegalStateException("getX called on empty Point");
		}
		return coordinate.x;
	}

	public double getY() {
		if (coordinate == null) {
			throw new IllegalStateException("getY called on empty Point");
		}
		return coordinate.y;
	}

	public double getZ() {
		if (coordinate == null) {
			throw new IllegalStateException("getZ called on empty Point");
		}
		return coordinate.z;
	}

	public double getM() {
		if (coordinate == null) {
			throw new IllegalStateException("getM called on empty Point");
		}
		return coordinate.m;
	}

	@Override
	public String getGeometryType() {
		return enumGeomType.Point.toString();
	}

	@Override
	public Geometry getEnvelope() {
		return null;
	}

	@Override
	public int getDimension() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return coordinate == null;
	}

	@Override
	public boolean is3D() {
		return isEmpty() ? false : coordinate.is3D();
	}

	@Override
	public boolean isMeasured() {
		return isEmpty() ? false : coordinate.isMeasured();
	}

	@Override
	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public Coordinate[] getCoordinates() {
		return isEmpty() ? new Coordinate[] {}
				: new Coordinate[] { getCoordinate() };
	}

	@Override
	public String asText() {
		return null;
	}

	@Override
	public byte[] asBinary() {
		return null;
	}
}
