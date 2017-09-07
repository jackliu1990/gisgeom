package com.gs.gis.geometry;


public class LineString extends Curve {
	private static final long serialVersionUID = -8907208844625565572L;
	private final Point[] points;

	public LineString() {
		points = new Point[]{};
	}
	
	public LineString(Point[] points) {
		this.points = points;
	}

	@Override
	public String geometryType() {
		return enumGeomType.LineString.toString();
	}
	

	public int numPoints() {
		return points.length;
	}

	public void addPoint(Point point) {
		int index = points.length+1;
		points[index]=point;
	}
	
	public Point pointN(int index) {
		return points[index];
	}

	@Override
	public Point startPoint() {
		return points[0];
	}

	@Override
	public Point endPoint() {
		int num = numPoints();
		return points[num-1];
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
		return points.length==0;
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
