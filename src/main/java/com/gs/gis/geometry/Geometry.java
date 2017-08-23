package com.gs.gis.geometry;

import java.io.Serializable;

public abstract class Geometry implements Serializable {
	private static final long serialVersionUID = 5594065733859514709L;

	private int srid;
	
	public Geometry(){}

	public Geometry(int srid) {
		this.srid = srid;
	}

	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
	}
	
	public abstract String getGeometryType();
	
	public abstract Geometry getEnvelope();
	
	public abstract int getDimension();
	
	public abstract boolean isEmpty();

	public abstract boolean is3D();

	public abstract boolean isMeasured();
	
	public abstract Coordinate getCoordinate();
	
	public abstract Coordinate[] getCoordinates();
	
	public abstract String asText();
	
	public abstract byte[] asBinary();
	
	public abstract void normalize();
	
	public abstract void reverse();
	
	public abstract Geometry clone();
	
	abstract public Geometry boundary();

}
