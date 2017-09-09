package com.gs.gis.geometry;

public abstract class Surface extends Geometry {

	private static final long serialVersionUID = -6075485091792226407L;

	protected Surface() {
		
	}
	
	abstract public double area();
	
	abstract public Point centroid();
	
	abstract public Point pointOnSurface();
	
	abstract public MultiCurve<Curve> boundary();
}