package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;


public class LineString extends Curve {
	private static final long serialVersionUID = -8907208844625565572L;
	private final List<Point> points;

	public LineString() {
		points = new ArrayList<Point>();
	}
	
	public LineString(List<Point> points) {
		this.points = points;
	}

	@Override
	public EnumGeomType geometryType() {
		return EnumGeomType.LineString;
	}
	

	public int numPoints() {
		return points.size();
	}

	public void addPoint(Point point) {
		points.add(point);
	}
	
	public Point pointN(int index) {
		return points.get(index);
	}

	@Override
	public Point startPoint() {
		return points.get(0);
	}

	@Override
	public Point endPoint() {
		return points.get(this.numPoints()-1);
	}

	@Override
	public double length() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isClosed() {
		if(isEmpty()) {
			return false;
		}
		return false;
	}


	@Override
	public boolean isRing() {
		return isClosed() && isSimple();
	}


	@Override
	public Geometry envelope() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int dimension() {
		return 1;
	}


	@Override
	public boolean isEmpty() {
		return this.numPoints()==0;
	}


	@Override
	public boolean is3D() {
		return !isEmpty()&&this.pointN(0).is3D();
	}


	@Override
	public boolean isMeasured() {
		return !isEmpty()&&this.pointN(0).isMeasured();
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
	public Geometry boundary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Geometry geometry) {
		// TODO Auto-generated method stub
		return false;
	}
}
