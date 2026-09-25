public class MathUtils {
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative integers.");
        }
        if (n > 16) {
            throw new IllegalArgumentException("Factorial cannot exceed 16 due to integer overflow.");
        }
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }
}