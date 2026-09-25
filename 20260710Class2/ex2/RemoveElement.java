import java.util.*;

public class RemoveElement {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2));

		list.removeIf(n -> n == 2);

		System.out.println(list);
	}
}