package beans;

import java.io.Serializable;

/**
 * JavaBean for calculating Simple Interest (I = P * N * R / 100).
 */
public class SimpleInterestBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private double p; // Principal amount
    private double n; // Number of years
    private double r; // Rate of interest per annum

    // Default no-argument constructor (required for JavaBean)
    public SimpleInterestBean() {
    }

    // Getters and Setters for property 'p' / Principal
    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getPrincipal() {
        return p;
    }

    public void setPrincipal(double principal) {
        this.p = principal;
    }

    // Getters and Setters for property 'n' / Time in years
    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getTime() {
        return n;
    }

    public void setTime(double time) {
        this.n = time;
    }

    // Getters and Setters for property 'r' / Rate of interest
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getRate() {
        return r;
    }

    public void setRate(double rate) {
        this.r = rate;
    }

    // Business method to calculate Simple Interest
    public double getSimpleInterest() {
        return (p * n * r) / 100.0;
    }

    // Business method to calculate total amount (Principal + Interest)
    public double getTotalAmount() {
        return p + getSimpleInterest();
    }
}
