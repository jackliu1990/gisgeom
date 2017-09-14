package com.gs.gis.io.wkt;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

import com.gs.gis.geometry.Geometry;
import com.gs.gis.geometry.Point;

public class WKTReader {
	
	 private static final String EMPTY = "EMPTY";
	  private static final String COMMA = ",";
	  private static final String L_PAREN = "(";
	  private static final String R_PAREN = ")";
	  private static final String NAN_SYMBOL = "NaN";
	  private static StreamTokenizer tokenizer;
	public static Geometry readGeometry(String wellKnownText) throws IOException{
		StringReader reader = new StringReader(wellKnownText);
		try{
			return read(reader);
		}finally{
		   reader.close();	
		}
	}
	
	private static Geometry read(StringReader reader) throws IOException{
		tokenizer = new StreamTokenizer(reader);
		// set tokenizer to NOT parse numbers
	    tokenizer.resetSyntax();
	    tokenizer.wordChars('a', 'z');
	    tokenizer.wordChars('A', 'Z');
	    tokenizer.wordChars(128 + 32, 255);
	    tokenizer.wordChars('0', '9');
	    tokenizer.wordChars('-', '-');
	    tokenizer.wordChars('+', '+');
	    tokenizer.wordChars('.', '.');
	    tokenizer.whitespaceChars(0, ' ');
	    tokenizer.commentChar('#');
	    
	    try{
	    	return readGeometryTaggedText();
	    }catch(IOException e){
	    	throw new IOException(e.toString());
	    }
	}
	
	private static String getNextWord() throws IOException{
		int type = tokenizer.nextToken();
		switch(type){
		case StreamTokenizer.TT_WORD:
			String word = tokenizer.sval;
			if(word.equalsIgnoreCase(EMPTY)){
				return EMPTY;
			}
			return word;
		}
		return "";
	}
	
	  private static String getNextEmptyOrOpener() throws IOException {
		    String nextWord = getNextWord();
		    if (nextWord.equals(EMPTY) || nextWord.equals(L_PAREN)) {
		      return nextWord;
		    }
		    parseErrorExpected(EMPTY + " or " + L_PAREN);
		    return null;
		  }
	  
	  private static void parseErrorExpected(String expected) throws IOException
		  {
		    // throws Asserts for tokens that should never be seen
		    if (tokenizer.ttype == StreamTokenizer.TT_NUMBER){
		      //Assert.shouldNeverReachHere("Unexpected NUMBER token");
		    }
		    if (tokenizer.ttype == StreamTokenizer.TT_EOL)
		    {
		      //Assert.shouldNeverReachHere("Unexpected EOL token");
		    }

		    String tokenStr = tokenString();
		    parseErrorWithLine("Expected " + expected + " but found " + tokenStr);
		  }
	  
	  
	  private static String tokenString() {
		    switch (tokenizer.ttype) {
		      case StreamTokenizer.TT_NUMBER:
		        return "<NUMBER>";
		      case StreamTokenizer.TT_EOL:
		        return "End-of-Line";
		      case StreamTokenizer.TT_EOF: return "End-of-Stream";
		      case StreamTokenizer.TT_WORD: return "'" + tokenizer.sval + "'";
		    }
		    return "'" + (char) tokenizer.ttype + "'";
	}

	private static void parseErrorWithLine(String msg) throws IOException
			  {
			    throw new IOException(msg + " (line " + tokenizer.lineno() + ")");
			  }
	

	private static Geometry readGeometryTaggedText() throws IOException{
		String type =null;
		try{
			type = getNextWord();
		}catch(IOException e){
			return null;
		}
		if(type.equalsIgnoreCase("POINT")){
			return readPointText();
		}
		return null;
	}

	private static Geometry readPointText() throws IOException {
		String nextToken = getNextEmptyOrOpener();
		if(nextToken.equals(EMPTY)){
			return new Point();
		}
		Point point = getPoint();
		getNextCloser();
		return point;
	}
	
	 private static Point getPoint()
		      throws IOException
		  {
		 Point point = new Point();
		 point.setX(getNextNumber());
		point.setY(getNextNumber());
		    if (isNumberNext()) {
		    	point.setZ(getNextNumber());
		    }
		    if()
		    return point;
		  }
		  
	private static double getNextNumber() throws IOException {
	    int type = tokenizer.nextToken();
	    switch (type) {
	      case StreamTokenizer.TT_WORD:
	      {
	      	if (tokenizer.sval.equalsIgnoreCase(NAN_SYMBOL)) {
	      		return Double.NaN;
	      	}
	      	else {
		        try {
		          return Double.parseDouble(tokenizer.sval);
		        }
		        catch (NumberFormatException ex) {
		          parseErrorWithLine("Invalid number: " + tokenizer.sval);
		        }
	      	}
	      }
	    }
	    parseErrorExpected("number");
	    return 0.0;
	  }

		private static boolean isNumberNext() throws IOException {
		    int type = tokenizer.nextToken();
		    tokenizer.pushBack();
		    return type == StreamTokenizer.TT_WORD;
		  }
	
	  private static String getNextCloser() throws IOException{
		    String nextWord = getNextWord();
		    if (nextWord.equals(R_PAREN)) {
		      return nextWord;
		    }
		    parseErrorExpected(R_PAREN);
		    return null;
		  }
}
