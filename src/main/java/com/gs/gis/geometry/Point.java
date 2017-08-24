package com.gs.gis.geometry;


public class Point extends Geometry {
	private static final long serialVersionUID = -5746654819330036683L;
	private double x;
	private double y;
	private double z = Double.NaN;
	private double m = Double.NaN;
	private boolean is3D = false;
	private boolean isMeasured = false;
	
	public Point(){
		
	}
	
	public Point (double x,double y){
		this.x =x;
		this.y =y;
	}
	
	public Point(double x,double y,double z){
		this.x = x;
		this.y = y;
		this.z = z;
		is3D = true;
	}
	
	public Point(double x,double y,double z,double m){
		this.x = x;
		this.y = y;
		this.z = z;
		is3D = true;
		isMeasured = true;
	}
	
	public double X() {	
		return x;
	}

	public double Y() {
		return y;
	}

	public double Z() {
		return z;
	}

	public double M() {
		return m;
	}

	@Override
	public String geometryType() {
		return enumGeomType.Point.toString();
	}

	@Override
	public Geometry envelope() {
		return null;
	}

	@Override
	public int dimension() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return x==Double.NaN||y==Double.NaN;
	}

	@Override
	public boolean is3D() {
		return is3D;
	}

	@Override
	public boolean isMeasured() {
		return isMeasured;
	}

	@Override
	public String asText() {
		return null;
	}

	@Override
	public byte[] asBinary() {
		return null;
	}

	@Override
	public Geometry boundary() {
		// TODO Auto-generated method stub
		return null;
	}
}
