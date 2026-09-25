import java.util.*;

public class ListIteration {
	public static void  main(String[] args) {
		List <String> list = Arrays.asList("Java",  "Python", "C++");

		System.out.println("FOR Loop: ");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("ENHANCED FOR Loop:");
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("Iterator: ");
		Iterator <String> it = list.iterator();
		while (it.hasNext ()) {
			System.out.println(it.next());
		}
	}
}