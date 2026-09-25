import java.util.*;

class student {
student (int n, String m) { id = n;
name = m;}
int id;
String name;
}

class Test3 {
public static void main(String args[]) {
student s1 = new student(91, "Kasi");
student s2 = new student(89, "Aasika");

s1.id = 91;
s1.name = "Kasi";

s2.id = 89;
s2.name = "Aasi";

System.out.println(s1.id + " " + s1.name);
System.out.println(s2.id + " " + s2.name);
}
}