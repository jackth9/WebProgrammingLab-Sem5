import java.util.HashMap;

public class FrequencyArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 1, 4, 2};

		HashMap <Integer, Integer> map = new HashMap<>();

		for(int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		System.out.println("Element Frequencies: ");

		for (Integer key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}
}