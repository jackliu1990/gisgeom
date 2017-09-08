package com.gs.gis.geometry;

public enum EnumGeomType {
	
	Geometry {
		@Override
		protected String typeWKT() {
			return "GEOMETRY";
		}

		@Override
		protected int typeWKB() {
			return 0;
		}
	},
	Point {
		@Override
		protected String typeWKT() {
			return "POINT";
		}

		@Override
		protected int typeWKB() {
			return 1;
		}
	},
	LineString {
		@Override
		protected String typeWKT() {
			return "LINESTRING";
		}

		@Override
		protected int typeWKB() {
			return 2;
		}
	},
	Polygon {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 3;
		}
	},
	MultiPoint {
		@Override
		protected String typeWKT() {
			return "MULTIPOINT";
		}

		@Override
		protected int typeWKB() {
			return 4;
		}
	},
	MultiLineString {
		@Override
		protected String typeWKT() {
			return "MULTILINESTRING";
		}

		@Override
		protected int typeWKB() {
			return 5;
		}
	},
	MultiPolygon {
		@Override
		protected String typeWKT() {
			return "MULTIPOLYGON";
		}

		@Override
		protected int typeWKB() {
			return 6;
		}
	},
	GeometryCollection {
		@Override
		protected String typeWKT() {
			return "GEOMETRYCOLLECTION";
		}

		@Override
		protected int typeWKB() {
			return 7;
		}
	},
	MultiCurve {
		@Override
		protected String typeWKT() {
			return "MULTICURVE";
		}

		@Override
		protected int typeWKB() {
			return 11;
		}
	},
	MultiSurface {
		@Override
		protected String typeWKT() {
			return "MultiPolygon";
		}

		@Override
		protected int typeWKB() {
			return 12;
		}
	},
	Curve{
		@Override
		protected String typeWKT(){
			return "POLYGON";
		}
		@Override
		protected int typeWKB(){
			return 13;
		}
	},
	Surface{
		@Override
		protected String typeWKT(){
			return "POLYGON";
		}
		@Override
		protected int typeWKB(){
			return 14;
		}
	},
	PolyhedralSurface {
		@Override
		protected String typeWKT() {
			return "MULTIPOLYGON";
		}

		@Override
		protected int typeWKB() {
			return 15;
		}
	},
	TIN {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 16;
		}
	},
	Triangle {
		@Override
		protected String typeWKT() {
			return "POLYGON";
		}

		@Override
		protected int typeWKB() {
			return 17;
		}
	},
	Line{

		@Override
		protected String typeWKT() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected int typeWKB() {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	LinearRing {
		@Override
		protected String typeWKT() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected int typeWKB() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	
	public String toString(){
		return name();
	}
	
	/**
	 * 返回枚举类型的序列号
	 * @return
	 */
	public int getCode(){
		return ordinal();
	}
	
	protected abstract String typeWKT();
	
	protected abstract int typeWKB();
}
