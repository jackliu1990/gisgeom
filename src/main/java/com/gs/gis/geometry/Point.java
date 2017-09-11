package com.gs.gis.geometry;


public class Point extends Geometry {
	private static final long serialVersionUID = -5746654819330036683L;
	private double x;
	private double y;
	private double z = Double.NaN;
	private double m = Double.NaN;
	
	public Point() {
		
	}
	
	public Point (double x,double y){
		this.x =x;
		this.y =y;
	}
	
	public Point(double x,double y,double z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.setIs3D(true);
	}
	
	public Point(double x,double y,double z,double m){
		this.x = x;
		this.y = y;
		this.z = z;
		this.setIs3D(true);
		this.setIsMeasured(true);
	}
	
	public double getX() {	
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getM() {
		return m;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setZ(double z){
		this.setIs3D(true);
		this.z = z;
	}
	
	public void setM(double m){
		this.setIsMeasured(true);
		this.m = m;
	}

	@Override
	public EnumGeomType geometryType() {
		return EnumGeomType.Point;
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
	public String asText() {
		return null;
	}

	@Override
	public byte[] asBinary() {
		return null;
	}

	@Override
    public int numPoints() {
	    return isEmpty() ? 0 : 1;
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
}
