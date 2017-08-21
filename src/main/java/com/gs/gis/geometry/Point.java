package com.gs.gis.geometry;

public class Point extends Geometry {
	private static final long serialVersionUID = -5746654819330036683L;
	private Coordinate coordinate;

	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Point(Coordinate coordinate, int srid) {
		super(srid);
		this.coordinate = coordinate;
	}

	@Override
	public enumGeomType geometryType() {
		return enumGeomType.Point;
	}


	@Override
	public boolean is3D() {
		return coordinate.is3D();
	}

	@Override
	public boolean isMeasured() {
		return coordinate.isMeasured();
	}

	public double getX() {
		return coordinate.getX();
	}

	public double getY() {
		return coordinate.getY();
	}

	public double getZ() {
		return coordinate.getZ();
	}

	public double getM() {
		return coordinate.getM();
	}

	public Coordinate getCoordinate() {
		return ;
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
		return coordinate.getDimension();
	}

	@Override
	public int getCoordinateDimension() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
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
}
