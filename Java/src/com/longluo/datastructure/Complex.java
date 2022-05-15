package com.longluo.datastructure;

/**
 *  Complex Number
 */
public class Complex {
    public double real;
    public double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    public Complex sub(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    public Complex mul(Complex other) {
        return new Complex(this.real * other.real - this.imag * other.imag, this.real * other.imag + this.imag * other.real);
    }
}
