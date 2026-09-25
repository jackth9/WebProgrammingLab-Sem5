import java.util.*;

class student {
int id;
String name;
}

class Test2 {
public static void main(String args[]) {
Scanner scanner1 = new Scanner(System.in);

student s1 = new student();
student s2 = new student();

s1.id = scanner1.nextInt();
System.out.println();
s1.name = scanner1.nextLine();

s2.id = 89;
s2.name = "Aasi";

System.out.println(s1.id + " " + s1.name);
System.out.println(s2.id + " " + s2.name);
System.out.println(s1.name.length());
}
}