package com.gs.gis.geometry;

public enum EnumGeomType {
	
	Geometry {
		@Override
		public String typeWKT() {
			return "GEOMETRY";
		}

		@Override
		public int typeWKB() {
			return 0;
		}
	},
	Point {
		@Override
		public String typeWKT() {
			return "POINT";
		}

		@Override
		public int typeWKB() {
			return 1;
		}
	},
	LineString {
		@Override
		public String typeWKT() {
			return "LINESTRING";
		}

		@Override
		public int typeWKB() {
			return 2;
		}
	},
	Polygon {
		@Override
		public String typeWKT() {
			return "POLYGON";
		}

		@Override
		public int typeWKB() {
			return 3;
		}
	},
	MultiPoint {
		@Override
		public String typeWKT() {
			return "MULTIPOINT";
		}

		@Override
		public int typeWKB() {
			return 4;
		}
	},
	MultiLineString {
		@Override
		public String typeWKT() {
			return "MULTILINESTRING";
		}

		@Override
		public int typeWKB() {
			return 5;
		}
	},
	MultiPolygon {
		@Override
		public String typeWKT() {
			return "MULTIPOLYGON";
		}

		@Override
		public int typeWKB() {
			return 6;
		}
	},
	GeometryCollection {
		@Override
		public String typeWKT() {
			return "GEOMETRYCOLLECTION";
		}

		@Override
		public int typeWKB() {
			return 7;
		}
	},
	MultiCurve {
		@Override
		public String typeWKT() {
			return "MULTICURVE";
		}

		@Override
		public int typeWKB() {
			return 11;
		}
	},
	MultiSurface {
		@Override
		public String typeWKT() {
			return "MultiPolygon";
		}

		@Override
		public int typeWKB() {
			return 12;
		}
	},
	Curve{
		@Override
		public String typeWKT(){
			return "POLYGON";
		}
		@Override
		public int typeWKB(){
			return 13;
		}
	},
	Surface{
		@Override
		public String typeWKT(){
			return "POLYGON";
		}
		@Override
		public int typeWKB(){
			return 14;
		}
	},
	PolyhedralSurface {
		@Override
		public String typeWKT() {
			return "MULTIPOLYGON";
		}

		@Override
		public int typeWKB() {
			return 15;
		}
	},
	TIN {
		@Override
		public String typeWKT() {
			return "POLYGON";
		}

		@Override
		public int typeWKB() {
			return 16;
		}
	},
	Triangle {
		@Override
		public String typeWKT() {
			return "POLYGON";
		}

		@Override
		public int typeWKB() {
			return 17;
		}
	},
	Line{

		@Override
		public String typeWKT() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int typeWKB() {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	LinearRing {
		@Override
		public String typeWKT() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int typeWKB() {
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
	
	public abstract String typeWKT();
	
	public abstract int typeWKB();
}
