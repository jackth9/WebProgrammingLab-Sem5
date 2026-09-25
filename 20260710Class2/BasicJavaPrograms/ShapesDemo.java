class Circle {
	double radius;
	Circle(double radius) {
		this.radius = radius;
	}

	double area() {
		return Math.PI * radius;
	}

	double perimeter() {
		return 2 * Math.PI * radius;
	}
}

class Rectangle {
	double length, width;

	Rectangle (double length, double width) {
		this.length = length;
		this.width = width;
	}

	double area() {
		return length * width;
	}

	double perimeter() {
		return 2 * (length + width);
	}
}

class Triangle {
	double a, b, c;

	Triangle (double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	double perimeter() {
		return a + b + c;
	}

	double area() {
		double s = perimeter() / 2;
		return Math.sqrt (s * (s-a) * (s-b) * (s-c));
	}
}

public class ShapesDemo {
	public static void main (String[] args) {
		Circle c = new Circle(5);
		Rectangle r = new Rectangle(4, 6);
		Triangle t = new Triangle(3, 4, 5);

		System.out.println("Circle Area = " + c.area());
		System.out.println("Circle Perimeter = " + c.perimeter());

		System.out.println("Rectangle Area = " + r.area());
		System.out.println("Rectangle Perimeter = " + r.perimeter());

		System.out.println("Triangle Area = " + t.area());
		System.out.println("Triangle Perimeter = " + t.perimeter());
	}
}