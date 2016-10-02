import java.lang.*;
import java.util.*;
public final class Complex_Object {
	private final Object a, b;
	public Complex_Object(Object real, Object imaginary) {
		this.a = real;
		this.b = imaginary;
	}
	public Object getReal() {
		return a;
	}
	public Object getImaginary() {
		return b;
	}
	public Complex_Object add(Complex_Object number) {
		Object tempReal = number.getReal();
		Object tempImaginary = number.getImaginary();
		Object a = null, b = null;
		if( (this.a instanceof Integer && tempReal instanceof Integer)  && (this.b instanceof Integer && tempImaginary instanceof Integer) ) {
			a = ((Number)this.a).intValue() + ((Number)number.getReal()).intValue();
			b = ((Number)this.b).intValue() + ((Number)number.getImaginary()).intValue();
		}
		else if( (this.a instanceof Double && tempReal instanceof Double)  && (this.b instanceof Double && tempImaginary instanceof Double) ) {
			a = ((Number)this.a).doubleValue() + ((Number)number.getReal()).doubleValue();
			b = ((Number)this.b).doubleValue() + ((Number)number.getImaginary()).doubleValue();
		}
		else if( (this.a instanceof Float && tempReal instanceof Float)  && (this.b instanceof Float && tempImaginary instanceof Float) ) {
			a = ((Number)this.a).floatValue() + ((Number)number.getReal()).floatValue();
			b = ((Number)this.b).floatValue() + ((Number)number.getImaginary()).floatValue();
		}
		Complex_Object addition = new Complex_Object(a,b);
		return addition;
	}
	public Complex_Object subtract(Complex_Object number) {
		Object tempReal = number.getReal();
		Object tempImaginary = number.getImaginary();
		Object a = null, b = null;
		if( (this.a instanceof Integer && tempReal instanceof Integer)  && (this.b instanceof Integer && tempImaginary instanceof Integer) ) {
			a = ((Number)this.a).intValue() - ((Number)number.getReal()).intValue();
			b = ((Number)this.b).intValue() - ((Number)number.getImaginary()).intValue();
		}
		else if( (this.a instanceof Double && tempReal instanceof Double)  && (this.b instanceof Double && tempImaginary instanceof Double) ) {
			a = ((Number)this.a).doubleValue() - ((Number)number.getReal()).doubleValue();
			b = ((Number)this.b).doubleValue() - ((Number)number.getImaginary()).doubleValue();
		}
		else if( (this.a instanceof Float && tempReal instanceof Float)  && (this.b instanceof Float && tempImaginary instanceof Float) ) {
			a = ((Number)this.a).floatValue() - ((Number)number.getReal()).floatValue();
			b = ((Number)this.b).floatValue() - ((Number)number.getImaginary()).floatValue();
		}
		Complex_Object subtraction = new Complex_Object(a,b);
		return subtraction;
	}
	public Double absolute() {
		Object result = null;
		if ( this.a instanceof Integer && this.b instanceof Integer ) {
			Number a1 = ((Number)this.a).intValue() * ((Number)this.a).intValue();
			Number b1 = ((Number)this.b).intValue() * ((Number)this.b).intValue();
			result = a1.intValue() + b1.intValue(); 
		}
		else if ( this.a instanceof Double && this.b instanceof Double ) {
			Number a1 = ((Number)this.a).doubleValue() * ((Number)this.a).doubleValue();
			Number b1 = ((Number)this.b).doubleValue() * ((Number)this.b).doubleValue();
			result = a1.doubleValue() + b1.doubleValue(); 
		}
		if ( this.a instanceof Float && this.b instanceof Float ) {
			Number a1 = ((Number)this.a).floatValue() * ((Number)this.a).floatValue();
			Number b1 = ((Number)this.b).floatValue() * ((Number)this.b).floatValue();
			result = a1.floatValue() + b1.floatValue(); 
		}
		Double abs = new Double(Math.sqrt(((Number)result).doubleValue()));
		return abs;
	}
	public Complex_Object conjugate() {
		Object a = null, b = null;
		if( this.a instanceof Integer && this.b instanceof Integer ) {
			a = ((Number)this.a).intValue();
			b = -1 * ((Number)this.b).intValue();	
		}
		else if( this.a instanceof Double && this.b instanceof Double ) {
			a = ((Number)this.a).doubleValue();
			b = -1 * ((Number)this.b).doubleValue();	
		}
		else if( this.a instanceof Float && this.b instanceof Float ) {
			a = ((Number)this.a).floatValue();
			b = -1 * ((Number)this.b).floatValue();	
		}
		Complex_Object conjugation = new Complex_Object(a,b);
		return conjugation;
	}
	public Complex_Object multiply(Complex_Object number) {
		Object tempReal = number.getReal();
		Object tempImaginary = number.getImaginary();
		Object a = null, b = null;
		if( (this.a instanceof Integer && tempReal instanceof Integer)  && (this.b instanceof Integer && tempImaginary instanceof Integer) ) {
			a = ((Number)this.a).intValue() * ((Number)number.getReal()).intValue();
			b = ((Number)this.b).intValue() * ((Number)number.getImaginary()).intValue();
		}
		else if( (this.a instanceof Double && tempReal instanceof Double)  && (this.b instanceof Double && tempImaginary instanceof Double) ) {
			a = ((Number)this.a).doubleValue() * ((Number)number.getReal()).doubleValue();
			b = ((Number)this.b).doubleValue() * ((Number)number.getImaginary()).doubleValue();
		}
		else if( (this.a instanceof Float && tempReal instanceof Float)  && (this.b instanceof Float && tempImaginary instanceof Float) ) {
			a = ((Number)this.a).floatValue() * ((Number)number.getReal()).floatValue();
			b = ((Number)this.b).floatValue() * ((Number)number.getImaginary()).floatValue();
		}
		Complex_Object multiplication = new Complex_Object(a,b);
		return multiplication;
	}
	public void display() {
		if ( this.a instanceof Integer && this.b instanceof Integer ) {
			if( ((Number)this.b).intValue() >= 0 )
				System.out.println( ((Number)this.a).intValue() + " + " + ((Number)this.b).intValue() + "i" );
			else 
				System.out.println( ((Number)this.a).intValue() + " - " + (-1 * ((Number)this.b).intValue()) + "i" );	
		}
		else if ( this.a instanceof Double && this.b instanceof Double ) {
			if( ((Number)this.b).doubleValue() >= 0 )
				System.out.println( ((Number)this.a).doubleValue() + " + " + ((Number)this.b).doubleValue() + "i" );
			else 
				System.out.println( ((Number)this.a).doubleValue() + " - " + (-1 * ((Number)this.b).doubleValue()) + "i" );	
		}
		else if ( this.a instanceof Float && this.b instanceof Float ) {
			if( ((Number)this.b).floatValue() >= 0 )
				System.out.println( ((Number)this.a).floatValue() + " + " + ((Number)this.b).floatValue() + "i" );
			else 
				System.out.println( ((Number)this.a).floatValue() + " - " + (-1 * ((Number)this.b).floatValue()) + "i" );	
		}
	}
}