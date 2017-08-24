package com.gs.gis.geometry;

public abstract class Curve extends Geometry {
	private static final long serialVersionUID = -5925605665311300225L;
	
	abstract public double length();

	abstract public Point startPoint();

	abstract public Point endPoint();

	abstract public boolean isClosed();

	abstract public boolean isRing();

	@Override
	public String geometryType() {
		return enumGeomType.Curve.toString();
	}
	
}
