package com.gs.gis.geometry;

public class GeometryCollection extends Geometry {

	private static final long serialVersionUID = -4110148892147283192L;
	private final Geometry[] geometries;

	public GeometryCollection() {
		super();
		geometries = new Geometry[]{};
	}
	
	public GeometryCollection(Geometry[] geometries){
		this.geometries = geometries;
	}

	@Override
	public String geometryType() {
		return enumGeomType.GeometryCollection.toString();
	}
	
	public int numGeometries() {
		return geometries.length;
	}

	public Geometry geometryN(int index) {
		return geometries[index];
	}

	public void addGeometry(Geometry geometry) {
	    int index = geometries.length+1;
		geometries[index]=geometry;
	}

	@Override
	public Geometry envelope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dimension() {
		int dimension = Dimension.FALSE;
		for(int i=0;i<geometries.length;i++){
			dimension = Math.max(dimension, geometries[i].dimension());
		}
		return dimension;
	}

	@Override
	public boolean isEmpty() {
		for(int i=0;i<geometries.length;i++){
			if(!geometries[i].isEmpty()){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean is3D() {
		return !isEmpty()&&geometries[0].is3D();
	}

	@Override
	public boolean isMeasured() {
		return !isEmpty()&&geometries[0].isMeasured();
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
		    for (int i = 0; i < geometries.length; i++) {
		      numPoints += ((Geometry) geometries[i]).numPoints();
		    }
		    return numPoints;
		  }
}