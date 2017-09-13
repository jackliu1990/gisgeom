package com.gs.gis.geometry;

import java.io.Serializable;

import com.gs.gis.referenceSystems.SpatialReferenceSystem;

public abstract class Geometry implements Serializable {
	private static final long serialVersionUID = 5594065733859514709L;

	private SpatialReferenceSystem spatialRS;

	public Geometry() {
		
	}

	public int SRID() {
		return spatialRS.getID();
	}
	
	/**
	   * Returns true if the array contains any non-empty <code>Geometry</code>s.
	   *
	   *@param  geometries  an array of <code>Geometry</code>s; no elements may be
	   *      <code>null</code>
	   *@return             <code>true</code> if any of the <code>Geometry</code>s
	   *      <code>isEmpty</code> methods return <code>false</code>
	   */
	  protected static boolean hasNonEmptyElements(Geometry[] geometries) {
	    for (int i = 0; i < geometries.length; i++) {
	      if (!geometries[i].isEmpty()) {
	        return true;
	      }
	    }
	    return false;
	  }

	  /**
	   *  Returns true if the array contains any <code>null</code> elements.
	   *
	   *@param  array  an array to validate
	   *@return        <code>true</code> if any of <code>array</code>s elements are
	   *      <code>null</code>
	   */
	  protected static boolean hasNullElements(Object[] array) {
	    for (int i = 0; i < array.length; i++) {
	      if (array[i] == null) {
	        return true;
	      }
	    }
	    return false;
	  }
	  
	  /**
	   *  Returns the count of this <code>Geometry</code>s vertices. The <code>Geometry</code>
	   *  s contained by composite <code>Geometry</code>s must be
	   *  Geometry's; that is, they must implement <code>getNumPoints</code>
	   *
	   *@return    the number of vertices in this <code>Geometry</code>
	   */
	public abstract int numPoints();  
	
	public EnumGeomType geometryType(){
	   return EnumGeomType.Geometry;	
	}
	
	public String typeWKT() {
		return this.geometryType().typeWKT();
	}
	
	public int typeWKB() {
		int code= this.geometryType().typeWKB();
		if (this.is3D()) {
			code += 1000;
		}
		if (this.isMeasured()) {
			code += 2000;
		}
		return code;
	}
	
	public abstract Geometry envelope();
	
	public abstract int dimension();
	
	public abstract boolean isEmpty();
	
	public abstract boolean is3D();
	
	public abstract boolean isMeasured();
	
	public abstract String asText();
	
	public abstract byte[] asBinary();
	
	public abstract Geometry boundary();
	
	public abstract boolean equals(Geometry geometry); 
	
	public void setSpatialReference(SpatialReferenceSystem spatialRS){
		this.spatialRS = spatialRS;
	}
	
	public boolean isSimple()
    {
	   return true;
    }
	
}
