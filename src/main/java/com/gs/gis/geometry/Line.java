package com.gs.gis.geometry;

import java.util.List;

public class Line extends LineString {

	private static final long serialVersionUID = -6958471671889533156L;
	
	public Line() {
		super();
	}
	
	public Line(List<Point> points){
		super(points);
		validateConstruction();
	}
	
	public void validateConstruction(){
		if(!isEmpty()&&this.numPoints()!=2){
			throw new IllegalArgumentException(
					"Invalid number of points in Line (found " + this.numPoints() + " - must be 0 or = 2)");
		}
	}
	
	@Override
	public void addPoint(Point point) {
		int num = numPoints();
		if (num >= 2)
			return;
		super.addPoint(point);
	}
}