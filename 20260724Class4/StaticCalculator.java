class Calculator {

    static int powering(int num1, int num2) {
        return (int)Math.pow(num1, num2);
    }

    static double powerDouble(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}

public class StaticCalculator {

    public static void main(String args[]) {

        System.out.println("2^5 = " + Calculator.powering(2,5));

        System.out.println("2.5^3 = " + Calculator.powerDouble(2.5,3));
    }
}
