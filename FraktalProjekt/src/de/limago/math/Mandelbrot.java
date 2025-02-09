package de.limago.math;

public class Mandelbrot {
	
	private static final int MAXITER = 255; 
	
	private Complex linkeUntereEcke;
	private double breite;
	
	public Mandelbrot() {
		this(new Complex(-2.0, -1.25), 2.5);
	}
	
	public Mandelbrot(Complex linkeUntereEcke, double breite) {
		this.linkeUntereEcke = linkeUntereEcke;
		this.breite = breite;
	}
	
	public Complex createC(int x, int y, int size) {
		double delta = breite / (double) size;
		return new Complex(linkeUntereEcke.re() + x * delta, linkeUntereEcke.im() + y * delta);
	}
	
	public int iterate(Complex c) {
		int retval = 0;
		Complex z = new Complex();
		while(z.abs() < 2 ) {
			z = z.times(z);
			z = z.plus(c);
			retval ++;
			if (retval > MAXITER) return 0;
		}
		return retval;
	}

	
	
}
