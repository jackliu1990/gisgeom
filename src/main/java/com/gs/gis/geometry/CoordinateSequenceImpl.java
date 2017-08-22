package com.gs.gis.geometry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoordinateSequenceImpl implements CoordinateSequence,Serializable {

	private static final long serialVersionUID = 1L;
	
	private final List<Coordinate> coordinates;

	public CoordinateSequenceImpl() {
		coordinates = new ArrayList<Coordinate>();
	}

	public int size() {
		return coordinates.size();
	}

	public Coordinate get(int index) {
		return coordinates.get(index);
	}
	
}
