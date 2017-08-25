package com.gs.gis.geometry;

public class MultiPoint extends GeometryCollection {

	private static final long serialVersionUID = -4206522180686962708L;

	public MultiPoint(){
		
	}
	
	public MultiPoint(Point[] points){
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
		return new GeometryCollection();
	}
}
