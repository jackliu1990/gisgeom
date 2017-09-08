package com.gs.gis.geometry;

public enum enumGeomType {
	Geometry("Geometry"),
	Point("POINT"),
	Line("Line"),
	LineString("LineString"),
	LinearRing("LinearRing"),
	Curve("Curve"),
	Polygon("Polygon"),
	PolyhedralSurface("PolyhedralSurface"),
	Surface("Surface"),
	TIN("TIN"),
	Triangle("Triangle"),
	GeometryCollection("GeometryCollection"),
	MultiPoint("MultiPoint"),
	MultiLineString("MultiLineString"),
	MultiCurve("MultiCurve"),
	MultiPolygon("MultiPolygon"),
	MultiSurface("MultiSurface");
	
	private String geomtype;
	private enumGeomType(String geomType){
		this.geomtype = geomType;
	}
	
	@Override
	public String toString(){
		return this.geomtype;
	}
}
