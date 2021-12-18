/**How to use keyword of continue and break */

public class Exercise4
{
	/**Use integer for continue and break */
	public static void integer_function(int[] nums)
	{
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] % 2 == 0)
				continue;
			if(nums[i] == 7)
				break;
			System.out.print(nums[i] + " ");
		}
	}
	
	/**Use string for continue and break */
	public static void string_function(String[] str)
	{
		for(int i = 0; i < str.length; i++)
		{
			if(str[i].contains("horse"))
				continue;
			if(str[i].contains("ket"))
				break;
			System.out.print(str[i] + " ");
		}
	}

	public static void main(String[] args)
	{
		int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		String[] strings = new String[]{"cat", "dog", "laser horse", "ketchup", "horse"};

		integer_function(numbers);
		string_function(strings);
	}
}


/*
Continue:
1.The loop will pass this value and terminate by that position then go to begin of the loop and continue next value of loop count.

Break:
1.When the condition accord, the break this keyword will jump out this loop whatever end or not.
*/
