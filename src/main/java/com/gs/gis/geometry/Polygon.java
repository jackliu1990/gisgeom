package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Surface {

	private static final long serialVersionUID = -365994711439639146L;
	private  LinearRing exterorRing;
	private  List<LinearRing> interiorRings;

	public Polygon(){
		
	}
	
	public Polygon(LinearRing exterorRing) {
		this.exterorRing = exterorRing;
		interiorRings = new ArrayList<LinearRing>();
	}
	
	@Override
	public int dimension(){
		return 2;
	}
	
	

	@Override
	public String geometryType() {
		return enumGeomType.Polygon.toString();
	}

	public LinearRing exterorRing() {
		return exterorRing;
	}

	public int numInteriorRings() {
		return interiorRings.size();
	}

	public void addInteriorRing(LinearRing interiorRing) {
		interiorRings.add(interiorRing);
	}

	public LinearRing interiorRingN(int index) {
		return interiorRings.get(index);
	}

	@Override
	public Geometry envelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is3D() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMeasured() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String asText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] asBinary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Geometry geometry) {
		// TODO Auto-generated method stub
		return false;
	}

}
