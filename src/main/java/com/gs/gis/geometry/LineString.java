package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends Curve {
	private static final long serialVersionUID = -8907208844625565572L;
	private final List<Point> vertex;

	public LineString(int srid) {
		super(srid);
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
}
