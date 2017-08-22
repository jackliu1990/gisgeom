package com.gs.gis.geometry;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.*;

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
	
	@JsonIgnore
	public abstract String getGeometryType();
	
	@JsonIgnore
	public abstract Geometry getEnvelope();
	
	@JsonIgnore
	public abstract int getDimension();
	
	@JsonIgnore
	public abstract boolean isEmpty();

	@JsonIgnore
	public abstract boolean is3D();

	@JsonIgnore
	public abstract boolean isMeasured();
	
	public abstract Coordinate getCoordinate();
	
	public abstract Coordinate[] getCoordinates();
	
	@JsonIgnore
	public abstract String asText();
	
	@JsonIgnore
	public abstract byte[] asBinary();
	
}
