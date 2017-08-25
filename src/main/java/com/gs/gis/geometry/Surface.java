package com.gs.gis.geometry;

public abstract class Surface extends Geometry {

	private static final long serialVersionUID = -6075485091792226407L;

	protected Surface() {
		
	}
	
	public  double area() {
		return 0.0F;
	}
	
	public Point centroid() {
		return null;
	}
	
	public Point pointOnSurface() {
		return null;
	}
	
	@Override
	public MultiCurve boundary() {
		return null;
	}
}