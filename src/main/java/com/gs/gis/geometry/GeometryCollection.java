package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection<T extends Geometry> extends Geometry {

	private static final long serialVersionUID = -4110148892147283192L;
	private final List<T> geometries;

	public GeometryCollection() {
		super();
		geometries = new ArrayList<T>();
	}
	
	public GeometryCollection(List<T> geometries){
		this.geometries = geometries;
	}

	@Override
	public EnumGeomType geometryType() {
		return EnumGeomType.GeometryCollection;
	}
	
	public int numGeometries() {
		return geometries.size();
	}

	public Geometry geometryN(int index) {
		return geometries.get(index);
	}

	public void addGeometry(T geometry) {
		geometries.add(geometry);
	}

	@Override
	public Geometry envelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dimension() {
		int dimension = Dimension.FALSE;
		for(int i=0;i<this.numGeometries();i++){
			dimension = Math.max(dimension, this.geometryN(i).dimension());
		}
		return dimension;
	}

	@Override
	public boolean isEmpty() {
		for(int i=0;i<this.numGeometries();i++){
			if(!this.geometryN(i).isEmpty()){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean is3D() {
		return !isEmpty()&&this.geometryN(0).is3D();
	}

	@Override
	public boolean isMeasured() {
		return !isEmpty()&&this.geometryN(0).isMeasured();
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
	public Geometry boundary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Geometry geometry) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	  public int numPoints() {
		    int numPoints = 0;
		    for (int i = 0; i < this.numGeometries(); i++) {
		      numPoints += ((Geometry) this.geometryN(i)).numPoints();
		    }
		    return numPoints;
		  }
}