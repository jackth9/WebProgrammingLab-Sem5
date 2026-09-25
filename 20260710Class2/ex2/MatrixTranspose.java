public class MatrixTranspose {
	public static void main(String[] args) {
		int[][] A = {
			{1, 2, 3},
			{4, 5, 6}
		};
	
		for(int i=0; i<A[0].length; i++) {
			for(int j=0; j<A.length; j++) {
				System.out.print(A[j][i] + " ");
			}
		System.out.println();	
		}
	}
}
