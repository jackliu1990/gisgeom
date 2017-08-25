package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class Polygon extends Surface {

	private static final long serialVersionUID = -365994711439639146L;
	private final LinearRing exterorRing;
	private final List<LinearRing> interiorRings;

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

}
