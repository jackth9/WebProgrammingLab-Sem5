abstract class Marks{

    abstract double getPercentage();
}

class A extends Marks{

    int m1,m2,m3;

    A(int a,int b,int c){
        m1=a;
        m2=b;
        m3=c;
    }

    double getPercentage(){
        return (m1+m2+m3)/3.0;
    }
}

class B extends Marks{

    int m1,m2,m3,m4;

    B(int a,int b,int c,int d){
        m1=a;
        m2=b;
        m3=c;
        m4=d;
    }

    double getPercentage(){
        return (m1+m2+m3+m4)/4.0;
    }
}

public class AbstractClassMarks {

    public static void main(String args[]){

        Marks s1=new A(80,90,85);
        Marks s2=new B(75,85,90,95);

        System.out.println("Student A Percentage : "+s1.getPercentage());

        System.out.println("Student B Percentage : "+s2.getPercentage());
    }
}
