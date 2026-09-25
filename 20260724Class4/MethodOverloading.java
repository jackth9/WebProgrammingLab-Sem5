class Printer {

    void print(int n, char c) {
        System.out.println("Integer : " + n);
        System.out.println("Character : " + c);
    }

    void print(char c, int n) {
        System.out.println("Character : " + c);
        System.out.println("Integer : " + n);
    }
}

public class MethodOverloading {
    public static void main(String args[]) {

        Printer p = new Printer();

        p.print(10, 'A');
        p.print('B', 20);
    }
}
