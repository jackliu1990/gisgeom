package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends Curve {
	private static final long serialVersionUID = -8907208844625565572L;
	private final List<Point> vertex;

	public LineString(int srid) {
		vertex = new ArrayList<Point>();
	}


	@Override
	public String getGeometryType() {
		return enumGeomType.LineString.toString();
	}
	

	public int getNumPoints() {
		return vertex.size();
	}

	public void addPoint(Point point) {
		vertex.add(point);
	}

	public Point pointN(int index) {
		return vertex.get(index);
	}

	@Override
	public Point startPoint() {
		return vertex.get(0);
	}

	@Override
	public Point endPoint() {
		int num = getNumPoints();
		return vertex.get(num - 1);
	}


	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isRing() {
		// TODO Auto-generated method stub
		return false;
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


	@Override
	public void normalize() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Geometry clone() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Geometry boundary() {
		// TODO Auto-generated method stub
		return null;
	}
}
