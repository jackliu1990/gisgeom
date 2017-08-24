package com.gs.gis.geometry;

public class Line extends LineString {

	private static final long serialVersionUID = -6958471671889533156L;
	
	private Point start,end;
	public Line() {
		
	}
	public Line(Point start,Point end) {
		this.start = start;
		this.end=end;
	}

	@Override
	public void addPoint(Point point) {
		int num = numPoints();
		if (num >= 2)
			return;
		super.addPoint(point);
	}
}