package com.gs.gis.referenceSystems;

public class SpatialReferenceSystem implements ReferenceSystem {
	private int srid;
	public SpatialReferenceSystem(int srid) {
		this.srid =srid;
	}
	
	public int getID(){
		return this.srid;
	};
	
	public int setID(int srid) {
		return this.srid;
	}

	public int dimension() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String[] axisName() {
		// TODO Auto-generated method stub
		return null;
	}
}
