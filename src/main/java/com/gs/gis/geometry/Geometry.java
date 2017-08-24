package com.gs.gis.geometry;

import java.io.Serializable;

import com.gs.gis.referenceSystems.SpatialReferenceSystem;

public abstract class Geometry implements Serializable {
	private static final long serialVersionUID = 5594065733859514709L;

	private SpatialReferenceSystem spatialRS;

	public int SRID() {
		return spatialRS.getID();
	}
	
	public abstract String geometryType();
	
	public abstract Geometry envelope();
	
	public abstract int dimension();
	
	public abstract boolean isEmpty();

	public abstract boolean is3D();

	public abstract boolean isMeasured();
	
	public abstract String asText();
	
	public abstract byte[] asBinary();
	
	public abstract Geometry boundary();
	
	public void setSpatialReference(SpatialReferenceSystem spatialRS){
		this.spatialRS = spatialRS;
	}
}
