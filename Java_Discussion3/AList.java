public class AList {
	
	/** If else statement is used to consider item will added to the last or the place of position.
	  * For loop is copy arr to result which needed to new a new length to insert the value since 
	  * Array is not destructively.*/
	public static int[] insert(int[] arr, int item, int position) {
		int[] result = new int[arr.length + 1];

		if(result.length < position) {
			System.arraycopy(arr, 0, result, 0, result.length - 1);
			result[result.length - 1] = item;
		}
		else{
			System.arraycopy(arr, 0, result, 0, position);
			result[position] = item;
		}


		for(int i = position; i < result.length - 1; i++) {
			result[i+1] = arr[i];
		}
		return result;
	}

	public static void reverse(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	} 

	public static int[] replicate(int[] arr) {
		int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			temp += arr[i];
		}

		int[] result = new int[temp];
		
		temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = temp; j < arr[i] + temp; j++) {
				result[j] = arr[i];
			}
			temp += arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr;
		arr = new int[]{5, 9, 3, 4};

		int[] result = insert(arr, 100, 2);
		reverse(arr);

		result = replicate(arr);
	}
}