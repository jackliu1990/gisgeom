package com.gs.gis.geometry;

public class Line extends LineString {

	private static final long serialVersionUID = -6958471671889533156L;

	public Line(int srid) {
		super(srid);
	}

	@Override
	public void addPoint(Point point) {
		int num = getNumPoints();
		if (num >= 2)
			return;
		super.addPoint(point);
	}
}