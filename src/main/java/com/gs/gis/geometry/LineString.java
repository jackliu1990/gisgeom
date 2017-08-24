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
	public String geometryType() {
		return enumGeomType.LineString.toString();
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
		int num = numPoints();
		return points.get(num - 1);
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
		// TODO Auto-generated method stub
		return false;
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
		return points.size()==0;
	}


	@Override
	public boolean is3D() {
	    for(int i=0;i<this.numPoints();i++) {
	    	if(this.pointN(i).isEmpty()) {
	    		return true;
	    	}
	    }
		return false;
	}


	@Override
	public boolean isMeasured() {
		  for(int i=0;i<this.numPoints();i++) {
		    	if(this.pointN(i).isMeasured()) {
		    		return true;
		    	}
		    }
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
