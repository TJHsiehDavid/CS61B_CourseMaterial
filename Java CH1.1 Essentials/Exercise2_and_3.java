/** CS16B HW0 assignment*/

public class Exercise2_and_3
{
	/**Returns the maximum value from m */
	public static int max(int[] num)
	{
		int max = num[0];
		for(int i = 0; i < num.length; i++)
		{
			if(max < num[i])
				max = num[i];
		}
		return max;
	}
	public static void main(String[] args)
	{
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
}
