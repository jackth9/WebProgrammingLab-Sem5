import java.util.*;

public class ArrayListConversion {
	public static void main(String[] args) {
		String[] arr = {"Java", "Python", "C++"};
		
		List <String> list = Arrays.asList(arr);

		System.out.println("Array to list: ");
		System.out.println(list);

		String[] newArray = list.toArray(new String[0]);
	
		System.out.println("List to Array: ");
		System.out.println(Arrays.toString(newArray));
	}
}