package com.gs.gis.geometry;

public abstract class  MultiCurve extends GeometryCollection {

	private static final long serialVersionUID = -2388408099538846042L;

	public  MultiCurve(){
		
	}
	
    public  MultiCurve(Curve[] curves){
		super(curves);
	}

	public abstract boolean isClosed();
	
	public abstract boolean length();
	
	@Override
	public String geometryType() {
		return enumGeomType.MultiCurve.toString();
	}
	
}
