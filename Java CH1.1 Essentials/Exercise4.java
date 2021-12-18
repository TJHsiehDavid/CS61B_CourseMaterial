public class Exercise4
{
	public static void windowPosSum(int[] a, int n)
	{
		int sum;
		for(int i = 0; i < a.length; i++)
		{
			sum = 0;
			if(a[i] < 0)
				continue;

			for(int j = i; j <= i + n; j++)
			{
				if(j == a.length)
					break;
				
				sum += a[j];
				a[i] = sum;
			}
		}
	}

	public static void main(String[] args)
	{
		int a[] = {1, 2, -3, 4, 5, 4};
		int n = 3;
		windowPosSum(a, n);

		int b[] = {1, -1, -1, 10, 5, -1};
		int m = 2;
		windowPosSum(b, m);
		
		System.out.println(java.util.Arrays.toString(b));
	}
}
