package com.gs.gis.geometry;

public  abstract class MultiSurface extends GeometryCollection {

	private static final long serialVersionUID = -576621089666334510L;
	
	public MultiSurface(){
		
	}
	
	public MultiSurface(Surface[] surfaces){
		super(surfaces);
	}
	
	public abstract double area();
	
	public abstract Point centroid();
	
	public abstract Point pointOnSurface();

}
