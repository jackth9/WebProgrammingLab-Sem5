import java.util.Arrays;

public class ArraySubset {
	public static void main(String[] args) {	
		int[] arr = {10, 20, 30, 40, 50, 60};

		int[] subset = Arrays.copyOfRange(arr, 1, 4);

		System.out.println(Arrays.toString(subset));
	}
}