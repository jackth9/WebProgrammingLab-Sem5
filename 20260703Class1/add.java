import java.util.*;

class Add {
public static void main(String[] args) {
Scanner i1 = new Scanner(System.in);
int n1;
int n2;
int sum;

System.out.println("Enter first int:");
n1 = i1.nextInt();

System.out.println("Enter second int:");
n2 = i1.nextInt();

sum = n1+n2;

System.out.println("Sum is " + sum);
}
}