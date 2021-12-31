public class Flatten {

	public static int[] flatten(int[][] x) {
		int totalLength = 0;
		
		for(int[] item : x) {
			for(int i = 0; i < item.length; i++) {
				totalLength += 1;
			}
		}

		int[] a = new int[totalLength];
		int aIndex = 0;

		for(int[] item : x) {
			for (int item2 : item) {
				a[aIndex++] = item2;
			}
		}

		return a;
	}

	public static void main(String[] args) {
		int[][] x = new int[][]{{1, 2, 3}, {}, {7, 8}};
		
		int[] result = flatten(x);
	}
}