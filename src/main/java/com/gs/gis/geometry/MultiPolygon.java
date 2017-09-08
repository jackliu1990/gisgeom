package com.gs.gis.geometry;

import java.util.List;

public class MultiPolygon extends MultiSurface<Polygon> {

	private static final long serialVersionUID = -8538253533188517173L;
	
	public MultiPolygon(){
		
	}
	
	public MultiPolygon(List<Polygon> polygons){
		super(polygons);
	}
	
	@Override
	public int dimension(){
		return 2;
	}
	
	@Override
	public String geometryType() {
		return enumGeomType.MultiPolygon.toString();
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Point centroid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point pointOnSurface() {
		// TODO Auto-generated method stub
		return null;
	}
}