package com.gs.gis.geometry;

public class MultiLineString extends MultiCurve {

	private static final long serialVersionUID = 8789353483850475564L;
	
	public MultiLineString(){
		
	}
	
	public MultiLineString(LineString[] lineStrings){
	       super(lineStrings);
	}
    
	@Override
	public String geometryType() {
		return enumGeomType.MultiLineString.toString();
	}
	
	public int dimension(){
		return 1;
	}

	@Override
	public boolean isClosed() {
		if(isEmpty()){ return false;}
		for (int i = 0; i < this.numGeometries(); i++) {
		      if (!((LineString) this.geometryN(i)).isClosed()) {
		        return false;
		      }
		    }
		    return true;
	}

	@Override
	public boolean length() {
		// TODO Auto-generated method stub
		return false;
	}
}
