package com.gs.gis.geometry;

public class Coordinate {
	private double x;
	private double y;
	private double z = Double.NaN;
	private double m = Double.NaN;
	private boolean is3D = false;
	private boolean isMeasured = false;

	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	public static final int M = 3;

	public Coordinate(double x, double y, double z, double m) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.m = m;
		isMeasured = true;
	}

	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		is3D = true;
	}

	public Coordinate() {
		this(0.0, 0.0);
	}

	public Coordinate(Coordinate c) {
		this(c.x, c.y, c.z);
	}

	public Coordinate(double x, double y) {
		this(x, y, Double.NaN);
	}

	public void setCoordinate(Coordinate other) {
		x = other.x;
		y = other.y;
		z = other.z;
		m = other.m;
	}

	public double getOrdinate(int ordinateIndex) {
		switch (ordinateIndex) {
		case X:
			return x;
		case Y:
			return y;
		case Z:
			return z;
		case M:
			return m;
		}
		throw new IllegalArgumentException("Invalid ordinate index: "
				+ ordinateIndex);
	}

	public void setOrdinate(int ordinateIndex, double value) {
		switch (ordinateIndex) {
		case X:
			x = value;
			break;
		case Y:
			y = value;
			break;
		case Z:
			z = value;
			break;
		case M:
			m = value;
			break;
		default:
			throw new IllegalArgumentException("Invalid ordinate index: "
					+ ordinateIndex);
		}
	}
	
	public boolean is3D(){
		return is3D;
	}
	
	public boolean isMeasured() {
		return isMeasured;
	}

	public int getDimension() {
		int dimension = 2;
		if (is3D & isMeasured == true)
			dimension = 4;
		else if (is3D ^ isMeasured == true)
			dimension = 3;
		return dimension;
	}
}
