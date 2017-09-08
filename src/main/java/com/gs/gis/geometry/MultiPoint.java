package com.gs.gis.geometry;

import java.util.List;

public class MultiPoint extends GeometryCollection<Point> {

	private static final long serialVersionUID = -4206522180686962708L;

	public MultiPoint(){
		
	}
	
	public MultiPoint(List<Point> points){
		super(points);
	}
	
	@Override
	public String geometryType() {
		return enumGeomType.MultiPoint.toString();
	}
	
	@Override
	public int dimension(){
		return 0;
	}
	
	@Override
	public Geometry boundary(){
		return new GeometryCollection<Point>();
	}
}
