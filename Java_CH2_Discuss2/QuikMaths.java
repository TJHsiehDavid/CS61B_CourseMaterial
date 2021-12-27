public class QuikMaths { 

	/** for each function is using x as the A's index value and go through A array,
	  * but x is not have any relation with A array, so it will not change the value of A.
	  * */
	public static void multiplyBy3(int[] A) { 
		for (int x: A) { 
			x = x * 3; 
		} 
	} 


	/** B is point to A's object which is an array, and when B point to A's index, it can also change
	  * the value of the A. More important is that B is point to A so actually the change is on A array.
	  * */
	public static void multiplyBy2(int[] A) { 
		int[] B = A; 
		for (int i = 0; i < B.length; i+= 1) { 
			B[i] *= 2; 
		} 
	} 

	public static void swap (int A, int B ) { 
		int temp = B; 
		B = A; 
		A = temp; 
	} 


	public static void main(String[] args) { 
		int[] arr; 
		arr = new int[]{2, 3, 3, 4}; 
		multiplyBy3(arr); 		/** value: 2,3,3,4*/

		arr = new int[]{2, 3, 3, 4}; 
		multiplyBy2(arr); 		/** value: 4,6,6,8*/

		int a = 6; 
		int b = 7; 
		swap(a, b); 			/** value: 6,7*/
	}
}