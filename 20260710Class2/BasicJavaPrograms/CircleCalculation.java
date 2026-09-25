import java.util.Scanner;

public class CircleCalculation {
	static final double PI = 3.14159;

	static double area(double radius) {
		return PI * radius * radius;
	}

	static double perimeter(double radius) {
		return 2 * PI * radius;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter radius: ");
		double r = sc.nextDouble();

		System.out.println("Area = " + area(r));
		System.out.println("Perimeter = " + perimeter(r));
	}
}