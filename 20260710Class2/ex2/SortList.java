import java.util.*;

public class SortList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Mango");
		list.add("Apple");
		list.add("Banana");

		Collections.sort(list);

		System.out.println(list);
	}
}