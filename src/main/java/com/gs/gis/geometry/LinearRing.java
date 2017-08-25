package com.gs.gis.geometry;

import java.util.List;

public class LinearRing extends LineString {

	private static final long serialVersionUID = 6646315907673558749L;
	/**
	 * The minimum number of vertices allowed in a valid non-empty ring (= 4). Empty
	 * rings with 0 vertices are also valid.
	 */
	public static final int MINIMUM_VALID_SIZE = 4;

	public LinearRing() {

	}

	public LinearRing(List<Point> points) {
		super(points);
		validateConstruction();
	}

	private void validateConstruction() {
		if (!isEmpty() && !super.isClosed()) {
			throw new IllegalArgumentException("Points of LinearRing do not form a closed linestring");
		}
		if (this.numPoints() >= 1 && this.numPoints() < MINIMUM_VALID_SIZE) {
			throw new IllegalArgumentException(
					"Invalid number of points in LinearRing (found " + this.numPoints() + " - must be 0 or >= 4)");
		}
	}

	public void close() {
		if (!isClosed()) {
			Point point = startPoint();
			addPoint(point);
		}
	}
	
	/**
	   * Tests whether this ring is closed.
	   * Empty rings are closed by definition.
	   * 
	   * @return true if this ring is closed
	   */
	@Override
	public boolean isClosed(){
		if(isEmpty()){
			return true;
		}
		return super.isClosed();
	}

	@Override
	public String geometryType() {
		return enumGeomType.LinearRing.toString();
	}

}
