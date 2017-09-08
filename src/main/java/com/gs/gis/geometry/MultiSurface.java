package com.gs.gis.geometry;

import java.util.List;

public  abstract class MultiSurface<T extends Surface> extends GeometryCollection<T> {

	private static final long serialVersionUID = -576621089666334510L;
	
	public MultiSurface(){
		
	}
	
	public MultiSurface(List<T> surfaces){
		super(surfaces);
	}
	
	public abstract double area();
	
	public abstract Point centroid();
	
	public abstract Point pointOnSurface();

}
