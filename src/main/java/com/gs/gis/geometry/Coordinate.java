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
}
