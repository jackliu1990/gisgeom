package com.gs.gis.geometry;

import java.util.List;

public abstract class  MultiCurve <T extends Curve> extends GeometryCollection<T> {

	private static final long serialVersionUID = -2388408099538846042L;

	public  MultiCurve(){
		
	}
	
    public  MultiCurve(List<T> curves){
		super(curves);
	}

	public abstract boolean isClosed();
	
	public abstract boolean length();
	
	@Override
	public String geometryType() {
		return enumGeomType.MultiCurve.toString();
	}
	
}
