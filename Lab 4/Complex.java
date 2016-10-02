public final class Complex {
	private final int a, b;
	private final static int NEGATIVE = -1;
	public Complex(int real, int imaginary) {
		this.a = real;
		this.b = imaginary;
	}
	public int getReal() {
		return a;
	}
	public int getImaginary() {
		return b;
	}
	public Complex add(Complex number) {
		int a = this.a + number.getReal();
		int b = this.b + number.getImaginary();
		Complex addition = new Complex(a,b);
		return addition;
	}
	public Complex subtract(Complex number) {
		int a = this.a - number.getReal();
		int b = this.b - number.getImaginary();
		Complex subtraction = new Complex(a,b);
		return subtraction;
	}
	public Double absolute() {
		double a1 = Math.pow(this.a,2);
		double b1 = Math.pow(this.b,2);
		double result = a1 + b1; 
		Double abs = new Double(Math.sqrt(result));
		return abs;
	}
	public Complex conjugate() {
		int a = this.a;
		int b = NEGATIVE * this.b;
		Complex conjugation = new Complex(a,b);
		return conjugation;
	}
	public Complex multiply(Complex number) {
		int a = this.a * number.getReal();
		int b = this.b * number.getImaginary();
		Complex multiplication = new Complex(a,b);
		return multiplication;
	}
	public void display() {
		if( this.b >= 0 )
			System.out.println( this.a + " + " + this.b + "i" );
		else 
			System.out.println( this.a + " - " + (NEGATIVE * this.b) + "i" );	
	}
}