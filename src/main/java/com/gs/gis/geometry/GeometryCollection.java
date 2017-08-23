package com.gs.gis.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends Geometry {

	private static final long serialVersionUID = -4110148892147283192L;
	private final List<Geometry> geometries;

	public GeometryCollection(int srid) {
		super(srid);
		geometries = new ArrayList<Geometry>();
	}

	@Override
	public String getGeometryType() {
		return enumGeomType.GeometryCollection.toString();
	}
	
	public int getNumGeometries() {
		return geometries.size();
	}

	public Geometry getGeometryN(int index) {
		return geometries.get(index);
	}

	public void addGeometry(Geometry geometry) {
		geometries.add(geometry);
	}

	@Override
	public Geometry getEnvelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDimension() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		for(int i=0;i<geometries.size();i++){
			if(!geometries.get(i).isEmpty()){
				return false;
			}
		}
		return true;
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
	public Geometry boundary() {
		// TODO Auto-generated method stub
		return null;
	}
}