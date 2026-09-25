public class LargestSmallest {
	public static void main(String[] args) {
		int[] arr = {12, 5, 78, 2, 34};

		int Largest = arr[0];
		int Smallest = arr[0];

		for(int num : arr) {
			if (num > Largest)
				Largest = num;
			if (num < Smallest)
				Smallest = num;
		}
		
		System.out.println("Largest = " + Largest);
		System.out.println("Smallest = " + Smallest);
	}
}